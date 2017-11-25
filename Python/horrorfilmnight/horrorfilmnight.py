def main():
    movies = []
    movies.append( sorted([int(x) for x in input().split()[1:]]) )
    movies.append( sorted([int(x) for x in input().split()[1:]]) )

    i0 = 0
    i1 = 0
    seen = 0
    last = 0
    while(i0 < len(movies[0]) and i1 < len(movies[1])):

        if movies[0][i0] == movies[1][i1]:
            last = 0
            seen += 1
            i0 += 1
            i1 += 1

        elif movies[0][i0] < movies[1][i1]:
            if (last != 1):
                last = 1
                seen += 1
            i0 += 1

        else:
            if (last != 2):
                last = 2
                seen += 1
            i1 += 1

    if (i0 < len(movies[0]) and last != 1) or (i1 < len(movies[1]) and last != 2):
        seen += 1

    print(seen)

if __name__ == '__main__':
    main()
