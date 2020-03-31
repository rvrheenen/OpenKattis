# approach is way too slow
from collections import deque

def main():
    global seed

    def traverse_groups(x, y, group_no):
        q = deque()
        q.append((x,y))
        count = 0
        while len(q) > 0:
            # if count > 1:
            #     exit()
            count +=1
            cx, cy = q.popleft()
            # groups[cx][cy] = group_no
            # print(f'{[cx,cy,groups[cx][cy]]}, {group_no}')
            for dir in [[1,0],[0,1],[-1,0],[0,-1]]:
                if 0 <= cx + dir[0] <= 99 and 0 <= cy + dir[1] <= 99:
                    nx = cx + dir[0]
                    ny = cy + dir[1]
                    # print(nx, ny)
                    if trees[nx][ny]:
                        if groups[nx][ny] != group_no:
                            groups[nx][ny] = group_no
                            # print(f'curr: {[cx,cy,groups[cx][cy]]} new tree {nx}, {ny} has {groups[nx][ny]} but should have {group_no}')
                            q.append((nx, ny))

    while True:
        try:
            seed, steps = [int(x) for x in input().split()]
        except EOFError:
            break

        trees = [[False for _ in range(100)] for _ in range(100)]
        trees_dict = dict()
        groups = [[-1 for _ in range(100)] for _ in range(100)]
        latest_group_no = 0

        fire_queries = [0 for _ in range(int(steps/100))]
        for i in range(steps):
            # if i == 30: break
            while True:
                new_tree = rand(seed) % 10000
                new_tree_x = new_tree // 100
                new_tree_y = new_tree % 100
                # print(new_tree_x, new_tree_y, len(trees), len(trees[0]))
                if not trees[new_tree_x][new_tree_y]:
                    trees[new_tree_x][new_tree_y] = True
                    trees_dict[i] = [new_tree_x, new_tree_y]
                    break

            existing_groups = set([groups[x][y] for x, y in directions(new_tree_x, new_tree_y) if groups[x][y] is not -1])

            # print(f'going to add new tree at {new_tree_x}, {new_tree_y} in group {latest_group_no} || {existing_groups}')
            if len(existing_groups) == 0:
                groups[new_tree_x][new_tree_y] = latest_group_no
                latest_group_no += 1
            else:
                groups[new_tree_x][new_tree_y] = next(iter(existing_groups))
                if len(existing_groups) > 1:
                    traverse_groups(new_tree_x, new_tree_y, groups[new_tree_x][new_tree_y])
            # print([groups[x][y] for x, y in directions(new_tree_x, new_tree_y) if groups[x][y] is not -1])

            tree_a = trees_dict.get(rand(seed) % (i+1))
            tree_b = trees_dict.get(rand(seed) % (i+1))
            # if trees[tree_a//100][tree_a%100] and trees[tree_b//100][tree_b%100]: # if both squares contain trees
            if tree_a and tree_b:
                # print(f'comparing {tree_a} {tree_a[0]}, {tree_a[1]} with {tree_b[0]}, {tree_b[1]}, \t groups are: {groups[tree_a[0]][tree_a[1]]} and {groups[tree_b[0]][tree_b[1]]}')
                if groups[tree_a[0]][tree_a[1]] == groups[tree_b[0]][tree_b[1]]: # if both trees in same groups
                    if groups[tree_b[0]][tree_b[1]] != -1: # if group is not -1
                        fire_queries[i//100] += 1

        # for row in groups:
        #     print(row)
        print(" ".join(str(x) for x in fire_queries))
        # exit()


def rand(s):
    global seed
    seed = (s*5171+13297) % 50021
    return seed

def directions(x,y):
    for dir in [[1,0],[0,1],[-1,0],[0,-1]]:
        if 0 <= x + dir[0] <= 99 and 0 <= y + dir[1] <= 99:
            yield x + dir[0], y + dir[1]




if __name__ == '__main__':
    main()
