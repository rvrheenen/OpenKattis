width, n_partitions = [int(x) for x in input().split()]
partitions = [int(x) for x in input().split()] +[width]

possibilities = set()
for partition in partitions:
    possibilities.add(partition)
    for other_partition in partitions:
        if partition == other_partition:
            break
        possibilities.add(abs(partition - other_partition))

print(" ".join(str(x) for x in sorted(possibilities)))
