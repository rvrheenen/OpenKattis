string = input()

for i in range(1, len(string)):
    if len(string) / i !=  len(string) // i: # check if a substring of length i is even feasible
        if i * 2 >= len(string):
            substring = string
            break
        continue

    substring = string[:i]

    broke = False
    for j in range(0, len(string), len(substring)): # check if all slices are correct
        if substring != string[j:j+len(substring)]:
            broke = True
            break
        substring = substring[-1]+substring[:-1] 
    if not broke:
        break

print(len(substring))
