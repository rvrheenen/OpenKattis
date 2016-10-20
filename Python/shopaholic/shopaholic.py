n = int(input())
items = sorted([int(x) for x in input().split()], reverse=True)

discount = 0
for i in range(2,n,3):
    discount += items[i]
print(discount)
