needed, provided = [int(x) for x in input().split()]

print("Dr. Chaz", end=" ")
print("will have" if provided >= needed else "needs", end=" ")
print(abs(provided - needed), end=" ")
if provided < needed:
    print("more", end=" ")
print("piece" if abs(provided - needed) == 1 else "pieces", end=" ")
print("of chicken", end="")
print(" left over!" if provided >= needed else "!")
