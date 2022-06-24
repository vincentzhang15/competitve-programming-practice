"""
CCC '18 J3 - Are we there yet?

O(1) solution by simplying adding.

@author Vincent Zhang
@since 24 June 2022
@context Programming practice
"""

import sys

def main():
    input = sys.stdin.readline
    output = sys.stdout.write

    a, b, c, d = map(int, input().split())
    output(f"0 {a} {a+b} {a+b+c} {a+b+c+d} \n")
    output(f"{a} 0 {b} {b+c} {b+c+d} \n")
    output(f"{a+b} {b} 0 {c} {c+d} \n")
    output(f"{a+b+c} {b+c} {c} 0 {d} \n")
    output(f"{a+b+c+d} {b+c+d} {c+d} {d} 0 \n")

if __name__=="__main__":
    main()