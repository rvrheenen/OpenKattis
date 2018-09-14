# Doesn't work for this problem, since input can be upto 1,000,000
import math
UNTILL = 500

def main():
    print("factorials = [", end="")
    for i in range(UNTILL + 1):
        print( len(str(math.factorial(i))), end="" )
        if i < UNTILL:
            print(", ", end="")
        if i % 20 == 0:
            print("\\")
    print("]")

if __name__ == '__main__':
    main()
