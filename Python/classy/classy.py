CLASS_KEYS = {"upper": "a", "middle": "b", "lower": "c"}

def convert_classes(line):
    classes = line.split(" ")[0]
    return "".join([CLASS_KEYS[c] for c in classes.split("-")][::-1])

def main():
    n_cases = int(input())

    for c in range(n_cases):
        n_people = int(input())

        people = {}
        longest_class = 0
        for p in range(n_people):
            name, classes = input().split(": ")
            coded_class = convert_classes(classes)
            people[name] = coded_class
            if len(coded_class) > longest_class:
                longest_class = len(coded_class)

        for k in people:
            people[k] = people[k] + (longest_class - len(people[k])) * CLASS_KEYS['middle']

        for v, k in sorted((v,k) for (k,v) in people.items()):
            print(k)

        print("".join(["=" for _ in range(30)]))


if __name__ == '__main__':
    main()
