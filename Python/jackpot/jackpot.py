from fractions import gcd

def lcm(a, b):
    return (a * b) // gcd(a, b)

N = int(input())
for i in range(N):
    number_of_wheels = int(input())
    wheels = [int(x) for x in input().split()]
    
    if number_of_wheels == 1:
        print(wheels[0])
    else:
        solution = lcm(wheels[0], wheels[1])
        for j in range(2,number_of_wheels):
            solution = lcm(solution, wheels[j])
        print(solution if solution <= 10**9 else "More than a billion.")