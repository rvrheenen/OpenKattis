N = int(input())

kat = {}
dom = {}
uniq_results = set()

for i in range(N):
    res = input()
    if kat.get(res):
        kat.update({res:kat.get(res)+1})
    else:
        kat.update({res:1})
    uniq_results.add(res)

for i in range(N):
    res = input()
    if dom.get(res):
        dom.update({res:dom.get(res)+1})
    else:
        dom.update({res:1})
    uniq_results.add(res)

total = 0
for i in uniq_results:
    if not kat.get(i) or not dom.get(i):
        continue
    total += min(kat.get(i), dom.get(i))
print(total) 
