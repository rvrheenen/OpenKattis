number = input()

if "".join(sorted(number, reverse=True)) == number:
    print(0)
else:
    i = int(number) + 1
    while(True):
        if sorted(number) == sorted(str(i)):
            print(i)
            break
        i+=1
