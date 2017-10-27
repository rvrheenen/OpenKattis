def main():
    n_lines = int(input())
    for i in range(n_lines):
        code = input()
        rc = int(len(code)**0.5) # amount of rows and columns
        for j in range(len(code)):
            print(code[(rc - 1 - j // rc) + ( rc * (j % rc))], end="")
        print()

if __name__ == '__main__':
    main()
