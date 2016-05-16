input()
throws = [int(x) for x in input().split()]
sorted_throws = throws.copy()
sorted_throws.sort(reverse=True)
for i in sorted_throws:
    if sorted_throws.count(i) == 1:
        print(throws.index(i)+1)
        exit()
print("none")