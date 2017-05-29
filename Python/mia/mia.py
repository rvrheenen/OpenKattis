def main():
    while True:
        throws = [int(x) for x in input().split()]

        if sum(throws) == 0:
            break

        p1 = calc_score(throws[:2])
        p2 = calc_score(throws[2:])

        if p1 == p2:
            print("Tie.")
        else:
            print("Player {} wins.".format(1 if p1 > p2 else 2))

def calc_score(eyes):
    eyes = sorted(eyes)
    if eyes == [1,2]:
        return 210
    return int("{e[1]}{e[0]}".format(e=eyes)) + (100 if eyes[0] == eyes[1] else 0)

if __name__ == '__main__':
    main()