case = 1
while(True):
    n_animals = int(input())
    if (n_animals == 0):
        break

    animals = {}
    for i in range(n_animals):
        animal = input().split()[-1:][0].lower()
        animals.update({animal:animals.get(animal)+1 if animal in animals else 1})

    print("List %d:" % case)
    for k,v in sorted(animals.items()):
        print("%s | %d" % (k, v))

    case += 1
