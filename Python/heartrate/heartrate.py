for _ in range(int(input())):
    beats, seconds = [float(x) for x in input().split()]
    print(f'{60*((beats-1)/seconds)} {(60*beats)/seconds} {60*((beats+1)/seconds)}')
