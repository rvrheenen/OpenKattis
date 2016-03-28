inp = input()
vowels = ["a", "e", "i", "o", "u"]
sentence = ""
i = 0;
while (i<len(inp)):
    letter = inp[i]
    sentence += letter
    if letter in vowels:
        i += 3
    else:
        i += 1
print(sentence)