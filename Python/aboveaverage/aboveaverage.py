def main():
    n_cases = int(input())

    for c in range(n_cases):
        case = [int(x) for x in input().split()][1:]
        average = sum(case) / len(case)
        amount_above = sum([1 for c in case if c > average])
        print(f'{(amount_above/len(case))*100:.3f}%')

if __name__ == '__main__':
    main()
