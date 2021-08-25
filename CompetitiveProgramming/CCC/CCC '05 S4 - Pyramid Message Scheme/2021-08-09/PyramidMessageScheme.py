"""
1
8
Alfred
Cindy
Alfred
Dennis
Alfred
Home
Betty
Home
"""
import sys;

def main():
    input = sys.stdin.readline
    for _ in range(int(input())):
        vis = {}
        dist = {}
        tree = {}
        root = None
        n = int(input())
        for i in range(n//2):
            start = input().strip()
            end = input().strip()

            if start in tree:
                tree[start].append(end)
            else:
                tree[start] = [end]
            
            if end in tree:
                tree[end].append(start)
            else:
                tree[end] = [start]

            vis[start] = False
            vis[end] = False

            dist[start] = 0
            dist[end] = 0

            root = end
        
        queue = [root]
        vis[root] = True
        dist[root] = 0
        while queue:
            cur = queue.pop(0)
            vis[cur] = True
            for name in tree[cur]:
                if not vis[name]:
                    vis[name] = True
                    dist[name] = dist[cur] + 1
                    queue.append(name)
        print( (n - max(dist.values())*2 ) * 10 )
main()