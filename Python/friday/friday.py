SUNDAY = 0
FRIDAY = 5

def main():
    n_cases = int(input())

    for _ in range(n_cases):
        n_days, n_months = map(int, input().split())
        months = map(int, input().split())

        day = SUNDAY
        friday13s = 0
        for month in months:
            for date in range(1, month + 1):
                if day == FRIDAY and date == 13:
                    friday13s += 1
                day = (day + 1) % 7

        print(friday13s)

if __name__ == '__main__':
    main()
