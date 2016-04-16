numwords = {  0 : 'zero', 1 : 'one', 2 : 'two', 3 : 'three', 4 : 'four', 5 : 'five',
              6 : 'six', 7 : 'seven', 8 : 'eight', 9 : 'nine', 10 : 'ten',
              11 : 'eleven', 12 : 'twelve', 13 : 'thirteen', 14 : 'fourteen',
              15 : 'fifteen', 16 : 'sixteen', 17 : 'seventeen', 18 : 'eighteen',
              19 : 'nineteen', 20 : 'twenty',
              30 : 'thirty', 40 : 'forty', 50 : 'fifty', 60 : 'sixty',
              70 : 'seventy', 80 : 'eighty', 90 : 'ninety' }

def num2text(n, capitalize = False):
    if n < 20 or n % 10 == 0:
        return make_capital(numwords[n], capitalize)
    return make_capital(numwords[(n//10)*10], capitalize)  + "-" + numwords[n-(n//10)*10]

def make_capital(string, capitalize):
    return string.capitalize() if capitalize else string

while(True):
    try:
        inp = input()
    except EOFError:
        break
    line = inp.split()
    for i in range(len(line)):
        word = line[i]
        if word.isdigit():
            line[i] = num2text(int(word), i == 0)
    print(" ".join(line))

