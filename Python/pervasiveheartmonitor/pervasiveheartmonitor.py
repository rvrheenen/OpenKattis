from statistics import mean
def is_numeric(txt):
    try:
        float(txt)
        return True
    except ValueError:
        return False
        
while(True):
    try:
        line = input().split()
        print(mean([float(x) for x in line if is_numeric(x)]), " ".join([x for x in line if x.isalpha()]))
    except EOFError:
        break
    

