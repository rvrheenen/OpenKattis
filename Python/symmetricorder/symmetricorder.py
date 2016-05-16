n = 1
while(True):
    amount_of_names = int(input())
    if amount_of_names == 0:
        break
    names = []
    for i in range(amount_of_names):
        if i%2 == 0:
            names.insert(int(i/2),input())
        else:
            names.insert(len(names)-int((i/2)), input())
    print("SET", n)
    n+=1
    for name in names:
        print(name)