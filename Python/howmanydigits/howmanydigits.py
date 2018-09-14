import math

def calc_num_digits(n):
    # Kamenetsky’s formula
    if n <= 1:
        return 1

    return math.ceil(n * math.log10(n/math.e) + math.log10(2 * math.pi * n) / 2 )


def main():
    while True:
        try:
            num = int(input())
            print(calc_num_digits(num))
        except EOFError:
            break

if __name__ == '__main__':
    main()
