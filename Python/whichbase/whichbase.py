for _ in range(int(input())):
    case, digits = input().split()
    print(f'{case} {int(digits, 8) if not any(x in digits for x in ["8", "9"]) else 0} {int(digits)} {int(digits, 16)}')
