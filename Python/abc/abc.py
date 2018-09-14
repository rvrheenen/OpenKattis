numbers = sorted(map(int, input().split()))
order = input()

dict = {}
for i in range(len("ABC")):
    dict["ABC"[i]] = numbers[i]

for letter in order:
    print(dict[letter], end=" ")
