book = []
used_words = set()
while(True):
    try:
        book += [input().split(" ")]
    except:
        break

for line in book:    
    output_line = ""
    for word in line:
        if word.lower() not in used_words:
            output_line += word if len(output_line) == 0 else " " + word
            used_words.add(word.lower())
        else:
            output_line += "." if len(output_line) == 0 else " ."
    print(output_line)