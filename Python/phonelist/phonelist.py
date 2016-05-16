# Time limit exceeded (was to be expected..)
def is_consistent(numbers):
    for n in range(len(numbers)):
        for m in range(n+1, len(numbers)):
            if numbers[n] == numbers[m][0:len(numbers[n])]:
                return False
    return True

N = int(input())
for i in range(N):
    amount = int(input())
    numbers = []
    for i in range(amount):
        numbers.append(input())
    numbers.sort()
    print("YES" if is_consistent(numbers) else "NO")