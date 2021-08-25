"""
4
2
1
2
4
3
3
3
3



NOTES

4
2
1
2
4

1 2 3 4
1 2 0 1

:2
:1,3
:
:4

boxes: [[1], [0, 2], [], [3]]
keys: [(0, []), (1, [1]), (1, [3]), (2, [0, 2])]
vis: [False, False, False, False]

"""

import gc

def main():
    for _ in range(2):
        n = int(input())
        boxes = [[] for _ in range(n)]
        vis = [False] * n

        for i in range(n):
            idx = int(input())-1
            boxes[idx].append(i)
            boxes[i].append(idx)

        count = 0
        for i in range(n):
            if not vis[i]:
                # DFS.
                stack = [i]
                while stack:
                    val = stack.pop()
                    for box in boxes[val]:
                        if not vis[box]:
                            vis[box] = True
                            stack.append(box)
                count += 1
        
        # Free memory to prevent memory limit exceeded exception, (max 32M for this problem).
        del boxes
        del vis
        gc.collect()

        print(count, end=" ")
main()