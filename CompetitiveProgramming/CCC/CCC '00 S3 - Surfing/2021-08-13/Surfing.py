"""
3
http://ccc.uwaterloo.ca
<HTML> <TITLE>This is the CCC page</TITLE>
Hello there boys
and girls.  <B>Let's</B> try <A HREF="http://abc.def/ghi"> a
little
problem </A>
</HTML>
http://abc.def/ghi
<HTML> Now is the <TITLE>time</TITLE> for all good people to program.
<A HREF="http://www.www.www.com">hello</A><A HREF="http://xxx">bye</A>
</HTML>
http://www.www.www.com
<HTML>
<TITLE>Weird and Wonderful World</TITLE>
</HTML>
http://ccc.uwaterloo.ca
http://www.www.www.com
http://www.www.www.com
http://ccc.uwaterloo.ca
The End


Link from http://ccc.uwaterloo.ca to http://abc.def/ghi
Link from http://abc.def/ghi to http://www.www.www.com
Link from http://abc.def/ghi to http://xxx
Can surf from http://ccc.uwaterloo.ca to http://www.www.www.com.
Can't surf from http://www.www.www.com to http://ccc.uwaterloo.ca.
"""

import sys, re

def dfs(data, s, e):
    vis = set([s])
    stack = [s]
    while stack:
        top = stack.pop()
        if top in data:
            for nxt in data[top]:
                if nxt not in vis:
                    vis.add(nxt)
                    stack.append(nxt)
                    if nxt == e:
                        return 1
    return 0


def main():
    input = sys.stdin.readline

    data = {}
    for _ in range(int(input())):
        a = input().strip()

        # For every line in a page.
        while 1:
            line = input().strip()
            if line == "</HTML>": break

            matches = list(map(lambda x: x[9:-1], re.findall("<A HREF=\".*?\"", line) ))
            for b in matches:
                if a in data:
                    data[a].append(b)
                else:
                    data[a] = [b]
                print(f"Link from {a} to {b}")
    
    # Process queries.
    while 1:
        a = input().strip()
        if a == "The End":
            break
        b = input().strip()

        if dfs(data, a, b):
            print(f"Can surf from {a} to {b}.")
        else:
            print(f"Can't surf from {a} to {b}.")
main()