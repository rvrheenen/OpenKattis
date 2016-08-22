def lists_are_equal(list1, list2):
    if len(list1) != len(list2):
        return False
    for i in range(len(list1)):
        if list1[i] != list2[i]:
            return False
    return True

N = int(input())

lineup = []
for i in range(N):
    lineup.append(input())

if lists_are_equal(lineup, sorted(lineup)):
    print("INCREASING")
elif lists_are_equal(lineup, sorted(lineup, reverse=True)):
    print("DECREASING")
else:
    print("NEITHER")