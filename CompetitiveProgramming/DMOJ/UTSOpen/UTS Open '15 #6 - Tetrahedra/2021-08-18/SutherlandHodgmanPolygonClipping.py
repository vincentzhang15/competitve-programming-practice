"""
https://stackoverflow.com/questions/17558077/finding-the-intersection-of-2-arbitrary-cubes-in-3d

https://rosettacode.org/wiki/Shoelace_formula_for_polygonal_area#Python

https://rosettacode.org/wiki/Sutherland-Hodgman_polygon_clipping#Python

Take the closed polygon defined by the points:

    [ ( 50 , 150 ) , ( 200 , 50 ) , ( 350 , 150 ) , ( 350 , 300 ) , ( 250 , 300 ) , ( 200 , 250 ) , ( 150 , 350 ) , ( 100 , 250 ) , ( 100 , 200 ) ]
    
and clip it by the rectangle defined by the points:

    [ ( 100 , 100 ) , ( 300 , 100 ) , ( 300 , 300 ) , ( 100 , 300 ) ] 
    
Print the sequence of points that define the resulting clipped polygon. 

"""


def clip(subjectPolygon, clipPolygon):
    def inside(p):
        return (cp2[0] - cp1[0]) * (p[1] - cp1[1]) > (cp2[1] -
                                                      cp1[1]) * (p[0] - cp1[0])

    def computeIntersection():
        dc = [cp1[0] - cp2[0], cp1[1] - cp2[1]]
        dp = [s[0] - e[0], s[1] - e[1]]
        n1 = cp1[0] * cp2[1] - cp1[1] * cp2[0]
        n2 = s[0] * e[1] - s[1] * e[0]
        n3 = 1.0 / (dc[0] * dp[1] - dc[1] * dp[0])
        return [(n1 * dp[0] - n2 * dc[0]) * n3, (n1 * dp[1] - n2 * dc[1]) * n3]

    outputList = subjectPolygon
    cp1 = clipPolygon[-1]

    for clipVertex in clipPolygon:
        cp2 = clipVertex
        inputList = outputList
        outputList = []
        s = inputList[-1]

        for subjectVertex in inputList:
            e = subjectVertex
            if inside(e):
                if not inside(s):
                    outputList.append(computeIntersection())
                outputList.append(e)
            elif inside(s):
                outputList.append(computeIntersection())
            s = e
        cp1 = cp2
    return (outputList)

print(clip([ ( 50 , 150 ) , ( 200 , 50 ) , ( 350 , 150 ) , ( 350 , 300 ) , ( 250 , 300 ) , ( 200 , 250 ) , ( 150 , 350 ) , ( 100 , 250 ) , ( 100 , 200 ) ], [ ( 100 , 100 ) , ( 300 , 100 ) , ( 300 , 300 ) , ( 100 , 300 ) ]))