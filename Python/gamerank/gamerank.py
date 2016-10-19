def stars_for_rank(rank):
    if rank >= 21:
        return 2
    if rank >= 16:
        return 3
    if rank >= 11:
        return 4
    return 5

rank = 25
stars = 0
streak = 0
record = list(input())
for game in record:
    if rank == 0:
        break
    if game == "W":
        streak += 1
        stars += (2 if streak >= 3 and rank >= 6 else 1)
        if stars > stars_for_rank(rank):
            stars = stars - stars_for_rank(rank)
            rank -= 1
    else:
        streak = 0
        if rank <= 20:
            if stars > 0:
                stars -= 1
            else:
                if rank < 20:
                    rank += 1
                    stars = stars_for_rank(rank) - 1
print(rank if rank > 0 else "Legend")