N = input()
for n in range(int(N)):
    X = input()
    cities = {}
    for x in range(int(X)):
        c = input()
        cities.update({c:c})
    print(len(cities))
