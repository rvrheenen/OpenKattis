n = int(input())
for i in range(n):
    dvd_count = int(input())
    dvds = [int(x) for x in input().split()]
    target = 1;
    for dvd in dvds:
        if dvd == target:
            target +=1
    print(dvd_count - (target - 1))