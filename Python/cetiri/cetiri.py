
def main():
    numbers = sorted([int(x) for x in input().split()])

    diffs = [numbers[i+1] - numbers[i] for i in range(len(numbers) - 1)]

    if diffs[0] == diffs[1]:
        print(max(numbers) + diffs[0])
    else:
        if diffs[0] > diffs[1]:
            print(numbers[0] + diffs[1])
        else:
            print(numbers[1] + diffs[0])

if __name__ == '__main__':
    main()
