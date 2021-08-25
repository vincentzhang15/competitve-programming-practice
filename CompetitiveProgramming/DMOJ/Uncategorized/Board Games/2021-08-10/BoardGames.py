# Python TLE

import heapq

def main():
    n, m = map(int, input().split())
    minn = min(n,m)//2
    MAX = int(1e7)
    maxx = max(n,m)*3
    dist = {}

    q = [-n]
    heapq.heapify(q)
    dist[n] = 0
    while q:
        top = -heapq.heappop(q)
        d = []
        d1 = top*3
        d2 = top-1
        d3 = top-3
        d4 = top // 2 if top % 2 == 0 else 0
        if d1 <= MAX:
            d.append(d1)
        if top % 2 != 0:
            d.append(d2)
        d.append(d3)
        if d4 != 0:
            d.append(d4)

        #print(dist)
        for dd in d:
            if dd >= minn and dd <= maxx:
                #print(dd, end=" ")
                if dd not in dist or dist[dd] > dist[top] + 1:
                    dist[dd] = dist[top] + 1
                    heapq.heappush(q, -dd)
    print(dist[m])

main()


"""
import heapq

def main():
    n, m = map(int, input().split())
    minn = min(n,m)//2
    MAX = int(1e7)
    maxx = max(n,m)*3
    dist = {}

    q = [-n]
    heapq.heapify(q)
    dist[n] = 0
    while q:
        top = -heapq.heappop(q)
        d = []
        d1 = top*3
        d2 = top-1
        d3 = top-3
        d4 = top // 2 if top % 2 == 0 else 0
        if d1 <= maxx and d1 <= MAX:
            d.append(d1)
        if top % 2 != 0:
            d.append(d2)
        d.append(d3)
        if d4 != 0:
            d.append(d4)

        #print(dist)
        for dd in d:
            if dd >= minn and dd <= maxx:
                #print(dd, end=" ")
                if dd not in dist or dist[dd] > dist[top] + 1:
                    dist[dd] = dist[top] + 1
                    if dd == m:
                        print(dist[dd])

                        
                        #print(dist)
                        return
                    heapq.heappush(q, -dd)
main()

"""