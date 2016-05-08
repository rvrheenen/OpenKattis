while(True):
    key = [int(x) for x in input().split()]
    key_len = key.pop(0)
    if key_len == 0:
        break
        
    line = input()
    if len(line) % key_len != 0:
        line += (key_len - (len(line) % key_len)) * " " 

    encrypted = "'"
    for i in range(int(len(line)/key_len)):
        block = line[(i*key_len):((i*key_len)+key_len)]
        encrypted += "".join([block[k-1] for k in key])
    print(encrypted+"'")