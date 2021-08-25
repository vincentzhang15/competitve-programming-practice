"""
5
3
3
18
4
4

VERDICT
Fastest Python AC (Last checked 12 August 2021)

"""

import sys

def main():
    input = sys.stdin.readline
    input()
    print(__import__("functools").reduce(__import__("operator").xor, map(int, iter(input, ''))))
main()