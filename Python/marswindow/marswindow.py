WINDOW = 26
START_YEAR = 2018
START_MONTH = 3

def main():
    year = int(input())

    years = [START_YEAR]
    month = 4
    while years[-1] < year:
        month += WINDOW
        years.append(years[-1] + month // 12)
        month %= 12

    print("yes" if year in years[-2:] else "no")

if __name__ == '__main__':
    main()
