"""
http://www.usaco.org/index.php?page=viewproblem2&cpid=567

SAMPLE INPUT:

7 10
4 8

SAMPLE OUTPUT:

6
"""


with open('paint.in') as file:
    data = file.readlines()
    inp = iter(data)
    a, b = map(int, next(inp).split())
    c, d = map(int, next(inp).split())

    total = b-a + d-c
    inter = max(min(b, d) - max(a, c), 0)
    ans = total - inter

    with open('paint.out', 'w') as file:
        print(ans, file=file)