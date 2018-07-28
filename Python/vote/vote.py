def main():
    n_cases = int(input())

    for _ in range(n_cases):
        n_candidates = int(input())
        votes = []

        for _ in range(n_candidates):
            votes.append(int(input()))

        if votes.count(max(votes)) > 1: # highest amount of votes occurs more than once
            print("no winner")
        else:
            print("{} winner {}".format(
                "majority" if max(votes) > 0.5 * sum(votes) else "minority",
                votes.index(max(votes)) + 1)
            )


if __name__ == '__main__':
    main()
