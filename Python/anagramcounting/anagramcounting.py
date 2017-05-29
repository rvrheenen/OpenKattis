import math
from collections import Counter

def main():
    while True:
        try:
            word = input()
        except EOFError:
            break

        # divide factorial of length of word by factorial of occurrence per letter ( eg: soon => 4!/(1!*2!*1!) )
        result = math.factorial(len(word))
        for letter, count in Counter(word).items():
            result //= math.factorial(count)
        print(int(result))

if __name__ == '__main__':
    main()