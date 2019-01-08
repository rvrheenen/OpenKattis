string = input()
odd_occurrences = len([x for x in [string.count(let) for let in set(string)] if x % 2 != 0])
print(max(odd_occurrences - 1, 0))
