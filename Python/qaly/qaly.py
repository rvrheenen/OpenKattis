years = int(input())

qaly = 0
for _ in range(years):
    q, p = [float(x) for x in input().split()]
    qaly += q * p 
print(qaly)    
