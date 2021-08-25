"""

10 3
8 4
3 8
4 2
3 2

yes

NOTES ##############
person: [taller people]
4: 8
8: 3
2: 4

a, b input, check if can go b-->a
3 2

if no check a --> b


PyPy3 submission.
"""

import sys, collections

def bfs(data, s, e, n):
    dist = [99999999] * (n+1)
    q = collections.deque([s])
    dist[s] = 0
    while q:
        top = q.popleft()
        for next in data.get(top, []):
            if dist[next] > dist[top] + 1:
                dist[next] = dist[top] + 1
                if next == e:
                    return 1
                q.append(next)
    return 0


def main():
    input = sys.stdin.readline

    n, m = map(int, input().split())
    data = {}
    for i in range(m):
        a, b = map(int, input().split())
        if b in data:
            data[b].append(a)
        else:
            data[b] = [a]
    e, s = map(int, input().split())

    if bfs(data, s, e, n):
        print("yes")
    elif bfs(data, e, s, n):
        print("no")
    else:
        print("unknown")

main()