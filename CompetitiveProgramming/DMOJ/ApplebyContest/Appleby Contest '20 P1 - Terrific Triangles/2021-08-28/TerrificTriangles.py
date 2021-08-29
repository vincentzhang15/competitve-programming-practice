"""
c2 = a2 + b2 -2ab cos C
C = acos( a2 + b2 -c2) / (2ab) )

https://www.quora.com/How-do-you-determine-if-a-triangle-is-right-acute-or-obtuse-based-on-side-lengths
"""

import sys, math

def identify(angles):
    if 90 in angles:
        return "R"
    else:
        for aa in angles:
            if aa > 90:
                return "O"
    return "A"

def main():
    input = sys.stdin.readline

    for _ in range(int(input())):
        a, b, c = map(int, input().split())

        maxx = max(a, b, c)
        minn = min(a, b, c)
        midd = a+b+c - maxx - minn

        val = minn*minn + midd*midd
        maxxSqr = maxx*maxx

        if val == maxxSqr:
            print("R")
        elif val < maxxSqr:
            print("O")
        else:
            print("A")


        """
        # This implementation of cosine law does not pass for some reason, maybe from floating point imprecisions.
        A = round( math.degrees( math.acos( (c*c + b*b -a*a) / (2 * c * b) ) ) )
        B = round( math.degrees( math.acos( (a*a + c*c -b*b) / (2 * a * c) ) ) )
        C = round( math.degrees( math.acos( (a*a + b*b -c*c) / (2 * a * b) ) ) )
        print(identify([A, B, C]))
        """

main()