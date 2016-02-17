inp = input().split(" ")
s = int(inp[0])
v1 = int(inp[1])
v2 = int(inp[2])
b1 = 0
b2 = 0

while (s >= v2):
    if s%v1 == 0:
        break
    s -= v2
    b2 += 1

while (s >= v1):
    s -= v1
    b1 +=1

if (s != 0):
    print("Impossible")
else:
    print(b1,b2)
    
#BELOW IS ATTEMPT AT RECURSION, NOT WORKING 
#
# def calcBottle(b1, b2):
#     global s, v1, v2
#     print(b1,b2)
#     total = getTotal(b1,b2)
#     if (total == s):
#         print("t")
#         return (b1, b2)
#     else:
#         print("b1,b2,total: ",b1,b2,total)
#         if (total < s + v1 + v2):
#             if (b1*v1 < s and b2 == 0):
#                 print("l1")
#                 return calcBottle(b1+1, b2)
#             else:
#                 print("l2")
#                 return calcBottle(b1, b2+1)

# def getTotal(b1, b2):
#     global v1, v2
#     return (b1*v1 + b2*v2)

# inp = input().split(" ")
# s = int(inp[0])
# v1 = int(inp[1])
# v2 = int(inp[2])
# r1,r2 = calcBottle(0,0)
# print("Result: ", r1, r2)
# if (getTotal(r1,r2) == s):
#     print(r1, r2)
# else:
#     print("Impossible")
