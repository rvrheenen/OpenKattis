import random

N_DWARVES = 7

def main():
    dwarves = []
    for i in range(N_DWARVES + 2):
        dwarves.append(int(input()))

    selection = random.sample(dwarves, N_DWARVES)
    while sum(selection) != 100:
        selection = random.sample(dwarves, N_DWARVES)


    print("\n".join([str(dwarve) for dwarve in dwarves if dwarve in selection]))


if __name__ == '__main__':
    main()
