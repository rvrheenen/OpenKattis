def main():
    n_experiments = int(input())
    experiments = [int(x) for x in input().split()]

    bacteria = 1
    reached_limit = False
    for exp in experiments:
        bacteria = (bacteria * 2) - exp
        if not reached_limit:
            if bacteria > 2**60:
                reached_limit = True
            if bacteria < 0:
                break
        else:
            bacteria = bacteria % (10**9 + 7)

    if bacteria < 0:
        print("error")
    else:
        print(bacteria % (10**9 + 7))

if __name__ == '__main__':
    main()
