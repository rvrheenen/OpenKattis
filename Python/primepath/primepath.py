from collections import deque

def get_input():
    # parse input
    n_cases = int(input())
    cases = []
    for _ in range(n_cases):
        cases.append([int(x) for x in input().split()])
    return cases

def sieve(n):
    # Sieve of Eratosthenes
    primes = [True for _ in range( n ) ]
    for i in range(2, int(n**0.5)):
        if primes[i]:
            for j in range(i+i, n, i):
                primes[j] = False
    return primes

def bfs(curr, goal, primes):
    # bfs to find the shortest route to
    visitable = set()
    for i in range(len(primes)):
        if primes[i]:
            visitable.add(str(i))

    q = deque()
    q.append((curr, 0))

    while len(q) > 0:
        curr, depth = q.popleft()
        if curr == goal:
            return depth
        elif len(visitable) == 0:
            return -1
        for i in range(len(curr)):
            for j in range(10):
                next = curr[:i] + str((int(curr[i])+j)%10) + curr[i+1:]
                if next in visitable:
                    visitable.remove(next)
                    q.append((next, depth + 1))
    return -1


def main():
    cases = get_input()

    primes = sieve(10000)

    for case in cases:
        print((lambda x: x if x >= 0 else "Impossible")(bfs(*[str(c) for c in case], primes)))

if __name__ == '__main__':
    main()
