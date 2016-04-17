cypher = input()
per = "PER"
count = 0
for i in range(len(cypher)):
    if cypher[i] != per[i%3]:
        count +=1
print(count)