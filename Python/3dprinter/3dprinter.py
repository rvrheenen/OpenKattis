print((lambda x: (1<<(x-1).bit_length()).bit_length() if x > 2 else x)(int(input())))
