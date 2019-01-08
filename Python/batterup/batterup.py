n_bats = int(input())
bats = [int(x) for x in input().split()]
print((sum(bats) + bats.count(-1)) / (n_bats - bats.count(-1)))
