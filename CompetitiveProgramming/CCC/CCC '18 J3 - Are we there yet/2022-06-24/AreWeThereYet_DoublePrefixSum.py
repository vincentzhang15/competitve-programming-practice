"""
CCC '18 J3 - Are we there yet?

Solution Logic:
 v
  3 10 12 5
   v
  3 10 12 5
  ...
           v
  3 10 12 5

  Insert pivot between each pair of numbers and compute prefix sum in either directions.

@author Vincent Zhang
@since 24 June 2022
@context Programming practice
"""

import sys, math

def frange(s, e, i):
    while s < e:
        yield s
        s += i

def main():
    input = sys.stdin.readline

    data = list(map(int, input().split()))
    E = len(data)

    for i in frange(-0.5, E, 1):
        idx_fwd = math.ceil(i)+1
        idx_rev = math.floor(i)

        out = data[:idx_rev+1] + [0] + data[idx_fwd-1:]
        for j in range(idx_fwd, E+1):
            out[j] += out[j-1] if j-1>=0 else 0
        for j in range(idx_rev, -1, -1):
            out[j] += out[j+1] if j+1<E else 0
        
        for o in out:
            print(o, end=" ")
        print()
        # print(" ".join(map(str, out)))

if __name__=="__main__":
    main()