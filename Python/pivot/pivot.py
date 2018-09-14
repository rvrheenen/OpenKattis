MAX_VAL = 2**31+1

def main():
    n_ints = int(input())
    ints = [int(x) for x in input().split()]

    # Find all potential pivots by iterating from the left side.
    highest = ints[0]
    potential_pivots = set()
    for i in ints:
        if i >= highest:
            potential_pivots.add(i)
            highest = i

    # Confirm pivots by iterating from right side.
    pivot_count = 0
    lowest = MAX_VAL
    for i in ints[::-1]:
        if i < lowest:
            if i in potential_pivots:
                pivot_count += 1
            lowest = i

    print(pivot_count)

if __name__ == '__main__':
    main()
