# TOO SLOW!
catalan = [1,1]
highest = 1
nQueries = int(input())
for c in range(nQueries):
    query = int(input())
    if query > highest:
        for i in range(highest+1, query+1):
            catalan.append(0)
            for j in range(0, i):
                catalan[i] += catalan[j] * catalan[i - j - 1]
        highest = query
    print(catalan[query])