N = int(input())
for i in range(N):
    input()
    guests = [int(x) for x in input().split()]
    for guest in guests:
        if guests.count(guest) == 1:
            print("Case #%d: %d" % (i+1, guest))
            break