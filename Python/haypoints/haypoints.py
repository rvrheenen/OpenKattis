m, n = [int(x) for x in input().split()]
haydict = {}
for i in range(m):
    a, b = input().split()
    haydict.update({a:int(b)})
count = 0
while(True):
    try:
        line = input().split()
        if len(line)>0:
            if line[0] == ".":
                print(count)
                count = 0
            else:
                for word in line:
                    if haydict.get(word):
                        count += haydict.get(word)
    except EOFError:
        break;