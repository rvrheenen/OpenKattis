from collections import deque

DIRECTIONS = [	[0,-1], [1,0], [0,1], [-1,0] ];
WATER = "0"
LAND = "1"
OCEAN = "2"
grid = []

def main():
    rows, cols = [int(x) for x in input().split()]

    # store map with additional water around it.
    grid.append([WATER for _ in range(cols+2)])
    for i in range(rows):
        grid.append([WATER] + list(input()) + [WATER])
    grid.append([WATER for _ in range(cols+2)])

    # matrix to store if cell has been visited
    visited = [[0 for _ in range(len(grid[0]))] for _ in range(len(grid))]

    coast_lines = 0

    # breadth-first traverse the water and count coast lines
    queue = deque()
    queue.append((0,0))
    while len(queue) > 0:
        r,c = queue.pop()
        if visited[r][c] == 0:
            visited[r][c] = 1
            if grid[r][c] == WATER:
                for dir in DIRECTIONS:
                    if 0 <= r+dir[0] < len(grid) and 0 <= c+dir[1] < len(grid[0]):
                        if grid[r+dir[0]][c+dir[1]] == WATER:
                            queue.append((r+dir[0], c+dir[1]))
                        else:
                            coast_lines += 1

    print(coast_lines)


if __name__ == '__main__':
    main()
