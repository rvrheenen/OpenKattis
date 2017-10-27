def get_matrix_dim(code_len):
    i = 1
    while(i <= code_len/i):
        if code_len/i == code_len//i:
            r = i
            c = int(code_len/i)
        i+=1
    return r,c

def main():
    code = input()
    rows, cols = get_matrix_dim(len(code))
    for r in range(rows):
        for c in range(cols):
            print(code[r + (c * rows)], end="")
    print()

if __name__ == '__main__':
    main()
