def main():
    n_experiments = int(input())
    experiments = [int(x) for x in input().split()]

    bacteria = 1
    for exp in experiments:
        bacteria *=2
        bacteria -= exp
        if bacteria < 0:
            break

    if bacteria < 0:
        print("error")
    else:
        print(bacteria % (10**9 + 7))


if __name__ == '__main__':
    main()
