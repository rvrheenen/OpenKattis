# Timelimit exceeded!
import random
import math

all_letters = "q w e r t y u i o p a s d f g h j k l z x c v b n m".split()

def gen_word(length):
    return "".join(random.sample(all_letters, length))

minimum, maximum = [int(x) for x in input().split()]

line = "a "
count = 1
while(count < minimum or count < maximum/2):
    count+=1
    line += gen_word(1 + int(math.log(count))) + " "

print(line.strip())
    