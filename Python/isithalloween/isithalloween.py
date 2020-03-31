inp = input()
print("yup" if any(x in inp for x in ["OCT 31", "DEC 25"]) else "nope")
