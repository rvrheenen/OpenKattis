fizz, buzz, limit = [int(x) for x in input().split()]
for i in range(1, limit+1):
    if i == 1 and fizz != 1:
        print(i)
    elif i % fizz == 0 and i % buzz == 0:
        print("FizzBuzz")
    elif i % fizz == 0:
        print("Fizz")
    elif i % buzz == 0:
        print("Buzz")
    else:
        print(i)