def count_digits(n):
    return sum([int(x) for x in n])

while(True):
    n = input()
    if n == "0":
        break
    s1 = count_digits(n)
    i = 11;
    while(count_digits(str(i*int(n))) != s1):
        i = i + 1
    print(i)