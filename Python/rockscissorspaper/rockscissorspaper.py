# WORKS BUT IT'S TOO SLOW

num_cases = int(input())

for i in range(num_cases):
    if i > 0:
        print()
    rows, cols, days = [int(x) for x in input().split()]
    grid = []
    for j in range(rows):
        grid.append(list(input()))

    for d in range(days):
        new_grid = [['' for _ in range(cols)] for _ in range(rows)]
        for r in range(rows):
            for c in range(cols):
                for o in range(4):
                    check = {0:[0,1], 1:[1,0], 2:[0,-1], 3:[-1,0]}[o]
                    check_r = r + check[0]
                    check_c = c + check[1]
                    if check_r < 0 or check_r > rows - 1 or check_c < 0 or check_c > cols - 1:
                        continue
                    
                    if {"R": "S", "S": "P", "P": "R"}[grid[check_r][check_c]] == grid[r][c]:
                        new_grid[r][c] = grid[check_r][check_c]
                        break

                if new_grid[r][c] == '':
                    new_grid[r][c] = grid[r][c]
        
        grid = [[col for col in row] for row in new_grid]
    
    for row in grid:
        print("".join(row))