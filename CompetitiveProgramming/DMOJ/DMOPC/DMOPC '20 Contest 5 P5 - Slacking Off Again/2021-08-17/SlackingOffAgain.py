"""
Thue-Morse Sequence
https://en.wikipedia.org/wiki/Thue%E2%80%93Morse_sequence

https://stackoverflow.com/questions/25131010/is-this-an-efficient-way-to-generate-the-thue-morse-sequence-in-python
https://stackoverflow.com/questions/5234090/how-to-take-the-first-n-items-from-a-generator-or-list

Shift generate string
a b c d
b c d e
c d e f
etc.

3 3
"""

import sys
import itertools

def genThueMorse():
    for n in itertools.count():
        yield bin(n).count('1') % 2

def main():
    input = sys.stdin.readline

    n, m = map(int, input().strip().split())
    s = ['B' if i else 'Y' for i in itertools.islice(genThueMorse(), 0, n+m)]

    for i in range(n):
        print("".join(s[i:i+m]))
main()