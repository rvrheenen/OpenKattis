# Doesn't work.

K = int(input())

Y = 0
i = 1
while (i*i <= K):
    if (K%i == 0):
        K = K/i
        Y+=1
        i = 1
    if (K==1):
        Y+=1
    i+=1
print(Y)