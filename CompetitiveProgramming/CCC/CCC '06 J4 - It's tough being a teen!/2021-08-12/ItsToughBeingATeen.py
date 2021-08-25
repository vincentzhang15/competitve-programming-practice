"""

6
2
5
4
0
0

3 5 6 2 1 4 7


1 7
1 4
2 1
3 4
3 5

6 2
5 4

No prerequisites
3
6

Stack
6, 3 pop 3, 5 pop 5
pop 6, 2 pop 2, 1

Visited
3, 5
6, 2, 1

Next task
1:[4, 7],
2:[1],
3:[4, 5]
6:[2]
5:[4]

Check valid
1: 2
2| 6
4: 1, 3 | 5
5: 3
7: 1

"""

import sys

def main():
    input = sys.stdin.readline

    task = {
        1:[4, 7],
        2:[1],
        3:[4, 5]
    }
    prereq = {
        1:[2],
        4:[1,2],
        5:[3],
        7:[1]
    }

    stack = [6, 3, 2]

    while 1:
        a, b = int(input()), int(input())
        if a == 0 and b == 0:
            break
        if a in task:
            task[a].append(b)
        else:
            task[a] = [b]
        
        if b in prereq:
            prereq[b].append(a)
        else:
            prereq[b] = [a]
        
        if b in stack:
            stack.remove(b)

    #print(task)
    #print(prereq)
    
    # Check
    vis = [0] * 8

    for s in stack:
        vis[s] = 1
    
    output = []

    while stack:
        top = stack.pop()
        #print(f"POP-------- {top}")
        if top in task:
            for t in sorted(task[top]):
                # Determine if should add t to stack.
                fail = 0
                for p in prereq[t]: # Check all t's pre-requisites.
                    if not vis[p]:
                        fail = 1
                        break
                if not fail:
                    output.append(top)
                    output.append(t)
                    vis[t] = 1
                    stack.append(t)
                #print(t, fail, "TEST")
        else:
            pass
            #output += str(t) + " "

    output = list(dict.fromkeys(output))
    fail = 0
    for i in range(1, 8):
        if i not in output:
            fail = 1
            break
    
    if fail:
        print(-1)
    else:
        print(" ".join([str(x) for x in output]))





    

main()