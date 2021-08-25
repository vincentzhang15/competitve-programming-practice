"""
BFS Path Track
https://stackoverflow.com/questions/8922060/how-to-trace-the-path-in-a-breadth-first-search/8922151#8922151

Time Complexity
https://stackoverflow.com/questions/2307283/what-does-olog-n-mean-exactly?rq=1

What is “:-!!” in C code?
https://stackoverflow.com/questions/9229601/what-is-in-c-code/9229793#9229793

2 1
1 2
1 2

"""

import sys, collections

# returns path.
def bfsPath(data, s, e):
    v = set()
    q = collections.deque([[s]])
    v.add(s)

    while q:
        path = q.popleft()
        curr = path[-1]
        if curr == e:
            return path
        for next in data.get(curr, []):
            if next not in v:
                q.append(path + [next])
                v.add(next)

def bfs(data, s, e, n):
    if s == e:
        return 0
    dist = [999999999] * n
    q = collections.deque([s])

    dist[s] = 0
    while q:
        curr = q.popleft()
        for next in data.get(curr, []):
            if dist[next] > dist[curr] + 1:
                dist[next] = dist[curr] + 1

                if next == e:
                    return dist[next]
                q.append(next)

def main():
    input = sys.stdin.readline
    n, m = map(int, input().split())
    data = {}

    for i in range(m):
        a, b = map(int, input().split())
        a -= 1
        b -= 1

        if a in data:
            data[a].append(b)
        else:
            data[a] = [b]

        if b in data:
            data[b].append(a)
        else:
            data[b] = [a]
    
    s, e = map(int, input().split())

    ######## TLE
    # path = bfsPath(data, s-1, e-1)
    # want = len(path) - 1
    # print(m-want)
    ########

	# Run with pypy3. Py3 TLE.
    val = bfs(data, s-1, e-1, n)
    print(m -val)

if __name__ == "__main__": main()