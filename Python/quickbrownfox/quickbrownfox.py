alpha = "abcdefghijklmnopqrstuvwxyz"
N = int(input())
for i in range(N):
    phrase = input().lower()
    missing = ""
    for a in alpha:
        if a not in phrase:
            missing += a
    print("pangram" if missing == "" else "missing", missing)
