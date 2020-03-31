def main():
    n_gnomes_orig, n_gnomes_remain = [int(x) for x in input().split()]

    gnomes_remain = []
    for _ in range(n_gnomes_remain):
        gnomes_remain.append(int(input()))

    gnomes_remain_tmp = set(gnomes_remain)
    missing_gnomes = [g for g in range(1, n_gnomes_orig + 1) if g not in gnomes_remain_tmp]

    i = 0
    for g in missing_gnomes:
        while i < len(gnomes_remain) and gnomes_remain[i] < g:
            print(gnomes_remain[i])
            i += 1
        print(g)

    if i < len(gnomes_remain):
        print("\n".join(str(g) for g in gnomes_remain[i:]))


if __name__ == '__main__':
    main()
