"""

notes

length of cross product of 2 vectors is area of parallelogram
/2 = triangle

vector dot itself is square of mag

"""

import sys

"""
import numpy as np
# pa: parallelogram a
# ta: triangle a
def surfaceAreaNumpy(a, b, c, d):
    # Area A: BC X BD.
    pa = np.cross( np.array(c)-np.array(b), np.array(d)-np.array(b) )
    ta = 0.5 * np.sqrt(pa.dot(pa))

    # Area B: AC x AD.
    pb = np.cross( np.array(c)-np.array(a), np.array(d)-np.array(a) )
    tb = 0.5 * np.sqrt(pb.dot(pb))

    # Area C: AB X AD.
    pc = np.cross( np.array(b)-np.array(a), np.array(d)-np.array(a) )
    tc = 0.5 * np.sqrt(pc.dot(pc))

    # Area D: AB X AC.
    pd = np.cross( np.array(b)-np.array(a), np.array(c)-np.array(a) )
    td = 0.5 * np.sqrt(pd.dot(pd))

    return ta+tb+tc+td
"""

def sub(a, b):
    return [aa - bb for aa, bb in zip(a, b)]

def cross(v1, v2):
    return [
        v1[1]*v2[2]-v1[2]*v2[1],
        v1[2]*v2[0]-v1[0]*v2[2],
        v1[0]*v2[1]-v1[1]*v2[0]
    ]

def dot(a, b):
    return sum([aa * bb for aa, bb in zip(a, b)])

# pa: parallelogram a
# ta: triangle a
def surfaceArea(a, b, c, d):
    # Area A: BC X BD.
    pa = cross( sub(c, b), sub(d, b) )
    ta = 0.5 * dot(pa, pa) ** 0.5

    # Area B: AC x AD.
    pb = cross( sub(c, a), sub(d, a) )
    tb = 0.5 * dot(pb, pb) ** 0.5

    # Area C: AB X AD.
    pc = cross( sub(b, a), sub(d, a) )
    tc = 0.5 * dot(pc, pc) ** 0.5

    # Area D: AB X AC.
    pd = cross( sub(b, a), sub(c, a) )
    td = 0.5 * dot(pd, pd) ** 0.5

    return ta+tb+tc+td

def main():
    input = sys.stdin.readline


    a1 = list(map(int, input().split()))
    b1 = list(map(int, input().split()))
    c1 = list(map(int, input().split()))
    d1 = list(map(int, input().split()))

    a2 = list(map(int, input().split()))
    b2 = list(map(int, input().split()))
    c2 = list(map(int, input().split()))
    d2 = list(map(int, input().split()))

    print(surfaceArea(a1, b1, c1, d1) + surfaceArea(a2, b2, c2, d2))
    # print(surfaceAreaNumpy(a1, b1, c1, d1) + surfaceAreaNumpy(a2, b2, c2, d2))


main()