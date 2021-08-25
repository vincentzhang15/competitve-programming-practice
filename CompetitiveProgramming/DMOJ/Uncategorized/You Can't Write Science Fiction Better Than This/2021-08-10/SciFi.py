"""

5 5 2 4
1 2
2 3
2 5
3 4
5 4

"""

import collections

# Returns min jumps.
def bfs(data, s, e, n):
    if s == e:
        return 0
    dist = [99999999] * (n+1)
    dist[s] = 0

    q = collections.deque([s])
    while q:
        front = q.popleft()
        for adj in data.get(front, []):
            if dist[adj] > dist[front] + 1:
                dist[adj] = dist[front] + 1

                if adj == e:
                    return dist[adj]
                q.append(adj)
    return -99999999999

def main():
    n, m, a, b = map(int, input().split())
    data = {}

    for i in range(m):
        x, y = map(int, input().split())
        if x in data:
            data[x].append(y)
        else:
            data[x] = [y]
        if y in data:
            data[y].append(x)
        else:
            data[y] = [x]
    
    summ = bfs(data, 1, a, n) + bfs(data, a, b, n)
    if summ < 0:
        print(-1)
    else:
        print(summ)
main()