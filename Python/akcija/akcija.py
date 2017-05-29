num_books = int(input())
books = []

for i in range(num_books):
    books.append(int(input()))

print( sum(books) - sum(sorted(books, reverse=True)[2::3]) )