# Works, but is too slow in the last case
trades = list(input())
queries = int(input())
for i in range(queries):
    points = [int(x) for x in input().split()]
    seq = 0
    while points[0] + seq < len(trades) and points[1] + seq < len(trades):
        if trades[points[0] + seq] == trades[points[1] + seq]:
            seq += 1
        else:
            break
    print(seq)
