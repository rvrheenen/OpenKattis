words = input().split()
print("yes" if len(words) == len(set(words)) else "no")
