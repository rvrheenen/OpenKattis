import math
time_allowed, n, algorithm = [int(x) for x in input().split()]

time_taken = 0
if algorithm == 1:
    if n >= 13:
        time_taken = time_allowed + 2
    else:
        time_taken = math.factorial(n)
elif algorithm == 2:
    time_taken = 2**n
elif algorithm == 3:
   time_taken = n**4 
elif algorithm == 4:
   time_taken = n**3 
elif algorithm == 5:
   time_taken = n**2 
elif algorithm == 6:
    time_taken = n * math.log(n, 2)
elif algorithm == 7:
    time_taken = n
print("AC" if time_taken <= time_allowed else "TLE")