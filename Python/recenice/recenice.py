num2words = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", \
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
num2words2 = ["twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]
def num2word(num):
    if num == 0:
        return ""
    if num < 20:
        return (num2words[num])
    elif num < 100:
        div = divmod(num,10)
        return (num2words2[div[0]-2]+num2word(div[1]))
    elif num < 1000:
        div = divmod(num,100)
        return(num2words[div[0]]+"hundred"+num2word(div[1]))

N = int(input())
words = []
for i in range(N):
    words.append(input().strip())

count = sum([len(x) for x in words if x != "$"])
for i in range(1,1000):
    number = num2word(i)
    if count + len(number) == i:
        break
solution = " ".join([x if x is not "$" else number for x in words])
print(solution)