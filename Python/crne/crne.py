def main():
    cuts = lambda n: ((n//2)+1) * ((n-(n//2))+1)
    print(cuts(int(input())))

if __name__ == '__main__':
    main()
