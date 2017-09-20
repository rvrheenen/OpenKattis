mb = int(input())
months = int(input())
print((mb * months) - sum([int(input()) for _ in range(months)]) + mb)
