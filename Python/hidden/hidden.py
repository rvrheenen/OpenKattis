password, message = input().split()

pass_pointer = 0
for m in message:
    if m == password[pass_pointer]:
        pass_pointer += 1
        if pass_pointer >= len(password):
            break
        continue
    if m in password[pass_pointer:]:
        break
if pass_pointer == len(password):
    print("PASS")
else:
    print("FAIL")