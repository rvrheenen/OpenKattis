n_people, n_trees = [int(x) for x in input().split()]
people = [[] for _ in range(n_people)]
while True:
    try:
        p, t = [int(x) for x in input().split()]
        people[p-1].append(t)
    except EOFError as e:
        break

opinions = set([str(sorted(heard)) for heard in people])
print(len(opinions))
