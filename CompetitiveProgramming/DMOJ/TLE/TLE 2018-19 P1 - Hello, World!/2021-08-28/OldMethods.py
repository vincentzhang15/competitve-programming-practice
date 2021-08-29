# Digit recognition of 28*28 pixel images.
"""
ORDER SENSITIVE
single Vertical bar
1
POTENTIAL ERROR: 1 WITH BOTTOM BAR

Bottom bar
2

Top bar
    if uppper 2/5 < lower 3/5 (or if vertical bar left)
    5
    else
    7
    POTENTIAL ERROR: 7 WITH MIDDLE BAR


Middle bar
4

Upper lower half unbalanced
6
9

Left right half unbalanced
3

Max area
8

Else
0

"""

"""
line area == solid area:
1
7

2
3
5

4

6
8
9
0
"""


"""
#########################################################################
############################ DIGIT GRAVEYARD ############################
    ###########################################################
    ############################ 4 ############################

    #printImage(inputImg)
    #print(segment)
    ##if max_right_diff in [1, 4, 6]:
    ##    if max_top_diff in [8, 11]:
    ##        if rQuintileSolid[4] <= 37:
    ##            if rQuintileSolid[1] >= 27:
    ##                return 4
    ##if nHolesStrict == 1 and holeAreaStrict[0] != 1:
    ##    if max_row_solid_5 - max_row_5 <= 6:
    ##        return 4
    ##    #printDigit()
    ###if segment == [1, 1, 0, 1, 0, 1, 0]: return 4
    #printDigit()


    ###########################################################
    ############################ 1 ############################
    # printDigit()
    #if max_right_diff in [*range(-3, 7+1), 11]:
    #if max_top_diff in [-3, -2, *range(3, 11+1)]:
    #if max_left_diff in [*range(-8, -6+1), *range(3, 8+1)]:
    #if max_bot_diff in [*range(-10, -5+1), *range(4, 10+1)]:
        #printDigit()
        #return 4
    #print(max_top_diff)
    #if max_top_diff >= 3:
    #    if max_bot_diff in [*range(-12, -3+1), *range(3, 10+1)]:
    #        return 4
    #    if cThirdsSolid[2] == max(cThirdsSolid):
    #        return 4
    #    # if max_top_diff <= 14 and max_bot_diff >= 4 and max_bot_diff <= 10:
    #    # if nHoles == 0 and max_top_diff >= 6 and max_top_diff <= 9:
    #        # return 4
    #    
    #    # if max_rows_5 == 1 and max_cols == 1 and max_row_5 == rowQuintile[2]:
    #        # return 4

    # if match41() >= 78: return 4
    # if match42() >= 82: return 4
    # if match43() >= 87: return 4
    #printDigit()

    #printDigit()


    ###########################################################
    ############################ 1 ############################
        # print((max_left_diff), abs(max_left_diff) <= 2, nHoles == 0, abs(max_right_diff) < 4, sum(widthFreq[2:7])*100/sum(widthFreq) > 90)
        if abs(max_left_diff) < 2 and abs(max_right_diff) < 4 and sum(widthFreq[2:7])*100/sum(widthFreq) > 90: # 701 width [2,6] > 90%
            # print("case 1")
            return 1
        # if max_left_diff == -1 and abs(max_left_diff_2) == 1 and abs(max_right_diff) == 1 and abs(max_left_diff) != 2 and abs(max_left_diff_2) != 2  and abs(max_right_diff_2) != 2 and abs(max_right_diff) != 2 and nHoles == 0:
        if max_left_diff == -1 and abs(max_right_diff) == 1 and range_top_diff < 10: # 513 flat sides
            #print("case 2")
            return 1

        ############### WORKING
        if abs(max_right_diff) == 1 and max_row_5 - min_row_5 <= 5: # +39 Even quintiles
            #print("case 3")
            return 1
        if abs(max_left_diff) < 3 and linearToTopRight() and max_right_diff < 2: # +41 top right diagonal DFS
            #print("case 4")
            return 1
        if abs(max_left_diff) < 4 and linearToTopLeft() and max_right_diff < 5: # +5 top left diagonal DFS
            #print("case 5")
            return 1
        
        # print(max_left_diff, max_right_diff, max_top_diff, max_bot_diff)
        if len(widthFreqLengths) == 1 and widthFreqLengths[0] <= 8 and abs(max_top_diff) < 5 and abs(max_left_diff) < 4 and abs(max_right_diff) < 2 and abs(max_bot_diff) < 5: # Distinct widths <= 8, must only have 1 width group, removes #1 bars
            return 1
        
        if abs(max_left_diff) < 4 and max_right_diff < 4 and abs(max_bot_diff) < 7 and containsDiagonal():
            #printDigit()
            return 1

        # if abs(max_left_diff) < 2 and nHoles == 0 and max_col_2 - min_col_2 <= 20 and diagonalTopRight(topContour, botContour) and abs(max_right_diff) < 2:
            # print("Case 6")
            # print(max_left_diff, max_right_diff)
            # return 1

        # if max_left_diff == -1 and nHoles == 0 and abs(lineArea - solidArea) <= 5:
            # return 1
        # if abs(max_right_diff) == 1 and abs(max_right_diff_2) != 2 and abs(max_right_diff) != 2 and nHoles == 0 and abs(lineArea - solidArea) <= 5:
            # return 1
        
        # count = 0
        #for i in range(width):
        #    if topContour[i] == 0 and botContour[i] == height-1 and nHoles == 0 and abs(max_right_diff) == 1:
        #        count += 1
        #if count >= 2:
        #    return 1

        # print(width-1, max(rightContour[:height//3]), min(rightContour[height*2//3:]), max(rightContour[:height//3]) == width-1 and min(rightContour[height*2//3:]) < width // 2)
        # a = height//3
        # b = height*2//3
        # print(rightContour)
        # if max(rightContour[:a]) == width-1 and rightContour[height//2] <= width // 2 and min(rightContour[b:]) < width // 3:
            # return 1
        # print(rowQuintile)

    ###########################################################
    ############################ 1 ############################
        ##for r in rQuintileSolid:
        ##    print(int(r), end="\t")
        ##print(min_row_solid_5 == rQuintileSolid[3] or min_row_solid_5 == rQuintileSolid[2])
        ##printDigit()

    #if match11() >= 87: return 1
    #if match12() >= 83: return 1

    ####if segment == [0, 1, 0, 1, 0, 0, 0]:return 1


    ###########################################################
    ############################ 6 ############################
    circleMatches = matchCircle(createCircle(3, 5))
    for match in circleMatches:
        if match[0] < 90:
            break
        if match[1] >= height // 2:
            return 6
    #####if segment == [1, 0, 1, 1, 0, 1, 1]:return 6


    ###########################################################
    ############################ 9 ############################
    #if segment == [1, 1, 0, 1, 1, 1, 1]:
        #return 9

    ###########################################################
    ############################ 0 ############################
    #if matchCircle(arcS(6, 8, depth=8*3//2))[0][0] >= 93 and matchCircle(arcN(6, 8, depth=8*3//2))[0][0] >= 93: # 268
        #return 0
    
    #printDigit()
    # printCircle(arcS(6, 8, depth=8*3//2))
    #printCircle(createCircle(5, 7))
    #time.sleep(2)

    
        ##print(holeLengths)
        ##if max_rows_5 == 2 and max_cols == 2 and rowQuintile[0] in max_rows_list_5 and rowQuintile[-1] in max_rows_list_5 and colQuintile[0] in max_cols_list and colQuintile[-1] in max_cols_list:
        ##    return 0
        ##if len(holeLengths) == 2 and 1 in holeLengths:
        ##    return 0

    # match01()

    ####if segment == [1, 1, 1, 1, 1, 0, 1]:return 0

    ###printImage(westInnerImg)
    ##if nHolesStrict == 1:
    ##    if len(west_inner_concavity) == 1:
    ##        if len(holeLengths) == 1 and holeLengths[0] >= 5:
    ##            if west_inner_concavity[0] <= -4:
    ##                return 0

    ####if segment == [1, 1, 1, 1, 1, 1, 1]:return 8

    ###########################################################
    ############################ 7 ############################
    ####if segment == [0, 1, 0, 1, 1, 0, 0] or segment == [0, 1, 0, 1, 1, 1, 0]:return 7


    ###########################################################
    ############################ 8 ############################
    #if quadrant24(leftContour, rightContour): # 763
        # return 8

    ###########################################################
    ############################ 8 ############################
    if matchCircle(arcW(2, 5, depth=4))[0][0] >= 80 and matchCircle(arcW(3, 6, depth=5))[0][0] >= 80 and matchCircle(arcE(3, 6, depth=5))[0][0] <= 78:
        if matchCircle(createCircle(2, 4))[0][1] < height // 2:
            if matchCircle(arcE(3, 6, depth=5))[0][2] * 100 / width >= 50:
                if upperCrescent():
                    return 3
    #printDigit()


    ###########################################################
    ############################ 5 ############################
    #if matchCircle(arcW(4, 6))[0][0] >= 90 and matchCircle(arcE(4, 6))[0][0] >= 90:
        #return 5

    ### if (max_row_5 == rowQuintile[0] or max_row_5 == rowQuintile[-1]) and max_cols >= 2:
    ##    #return 5
    ##if max_col_2-min_col_2 <= 20:
    ##    return 5
    ##if solidArea < 30:
    ##    return 5


    ###########################################################
    ############################ 2 ############################
            #if not segment[0] and segment[-1]:
            #print(segment)


    ###########################################################
    ###########################################################

    # westInnerImg = eraseLeftBorder(copy2D(img), rightContour)
    # westInnerContour = leftContours(westInnerImg)
    # west_inner_contours_diff_1 = firstDiff(westInnerContour[4:-4])
    # west_inner_contours_diff_2 = firstDiff(west_inner_contours_diff_1)
    # west_inner_concavity = findConcavity(west_inner_contours_diff_2, [*range(-30, -1+1), *range(2, 30+1)])
    


    # print(max_left_diff, max_right_diff, max_top_diff, max_bot_diff)
    # printDigit()


    #print(" =============== CONTOUR LEFTT DIFF ", left_contours)
    #print("@####################### l r contours diff max ", max_left_diff, max_right_diff)
    # print(max_right_diff_2)#, max_right_diff)


    # Potential problem with small sized numbers, e.g., box = 0 != 1
    ######################################### MIGHT BE USEFUL
    # if len(cAvg) < 8:
        # return 1 # EIGHTY 1s, TEN 3s, TEN 6s


    # print("linearea ", lineArea)
    # print("solidarea ", solidArea)

    #print(max_row_3 == rowThird[2])

    #print("HOLE LENGTHS", holeLengths)


    
    #if nHoles == 1:
    #    #return 0
    #    section = height//5
    #    a = height//2-section
    #    b = height//2+section
    #    for i in range(a, b):
    #        if i in holeIndex and (max_row_5 - min_row_5 <= 25 or max_row_3 - min_row_3 <= 11 or max_row_8 - min_row_8 <= 30):
    #            return 0
    #    # for i in range(0, a):
    #        # if i in holeIndex:
    #            # return 9
    #            # could be 4
    #    # for i in range(b, height):
    #        # if i in holeIndex:
    #            # return 6
    #            # could be 2
        

    #if abs(lineArea - solidArea) < 6:
    #    if abs(rowQuintile[2] - rowQuintile[3]) < 25 or abs(rowQuintile[0] - rowQuintile[1]) < 25 or max_row_5 == rowQuintile[-1]:
    #        return 1
    
    

    #if max_rows_5 == 2 and max_row_5 == rowQuintile[-1] and max_col == colQuintile[-1]:
        #return 2
    

    #max_cols = len([x for x in colQuintile if x >= max_col - 20])
    #if max_cols == 1:
        #return 3





    ###########################################################
    ###########################################################






def match41(): # Match digit 4, case 1: looks literally like 4.
    digit = [[1]*width for _ in range(height)]

    idx = 0
    for i in range(int(height*0.65), -1, -1):
        for j in range(min(round(idx), width)):
            digit[i][j] = 0
        idx+=0.86
    for i in range(int(height*0.8), height):
        for j in range(width):
            if j < width*0.65 or j >width*0.9:
                digit[i][j] = 0
    idx = 0
    for i in range(int(height*0.65)-1, height//3, -1):
        for j in range(round(idx)+6, int(width*0.65)+1):
            digit[i][j] = 0
        idx+=0.86

    return getImgMatchCount(digit)*100/(width*height)

def match42(): # Match digit 4, case 2
    digit = [[1]*width for _ in range(height)]

    for i in range(int(height*0.3)):
        for j in range(int(width*0.25), int(width*0.65)):
            digit[i][j] = 0
    idx = 0
    for i in range(int(height*0.2), height):
        for j in range(max(int(width-idx), 0), width):
            digit[i][j] = 0
        idx+=0.6
    for i in range(int(height*0.8), height):
        for j in range(int(width*0.2)):
            digit[i][j] = 0
    for i in range(int(height*0.2)):
        for j in range(int(width*0.9), width):
            digit[i][j] = 0
    idx = 2
    for i in range(height-1, int(height*0.4), -1):
        for j in range(int(min(idx, width))):
            digit[i][j] = 0
        idx+=0.6

    return getImgMatchCount(digit)*100/(width*height)

def cutRectangle(digit, r1, r2, c1, c2):
    for i in range(int(r1), int(r2)):
        for j in range(int(c1), int(c2)):
            digit[i][j] = 0
    return digit

def match43():
    digit = [[1]*width for _ in range(height)]

    idx = 0
    for i in range(int(height*0.6), -1, -1):
        for j in range(int(min(idx, width))):
            digit[i][j] = 0
        idx += 1
    cutRectangle(digit, 0, height*0.6, width*0.9, width)
    cutRectangle(digit, height*0.8, height, width*0.9, width)
    idx = 0
    for i in range(int(height*0.75), height):
        for j in range(int(width*0.65), int(max(0, width*0.65-idx)), -1):
            digit[i][j] = 0
        idx += 0.7
    idx = 0
    for i in range(int(height*0.85), height):
        for j in range(int(width*0.55), int(max(0, width*0.55-idx)), -1):
            digit[i][j] = 0
        idx += 3
    return getImgMatchCount(digit)*100/(width*height)

def match11():
    digit = [[1]*width for _ in range(height)]

    idx = 5
    for i in range(int(height*0.35), -1, -1):
        for j in range(min(int(idx), int(width*0.6))):
            digit[i][j] = 0
        idx+=0.5
    cutRectangle(digit, 0, height*0.8, width*0.8, width)
    cutRectangle(digit, height*0.5, height*0.8, 0, width*0.4)
    cutRectangle(digit, height*0.9, height, width*0.3, width)

    return getImgMatchCount(digit)*100/(width*height)

def match12():
    digit = [[1]*width for _ in range(height)]

    idx = 3
    for i in range(int(height*0.15), -1, -1):
        for j in range(min(int(idx), int(width*0.6))):
            digit[i][j] = 0
        idx+=0.5
    cutRectangle(digit, 0, height*0.8, width*0.65, width)
    cutRectangle(digit, height*0.3, height*0.8, 0, width*0.4)

    return getImgMatchCount(digit)*100/(width*height)




def extractCol(image, w, h):
    maxCol = 0
    maxIdx = 0
    for j in w:
        curCol = sum(image[i][j] >= darkest_point * 15 / 100 for i in h)
        if curCol > maxCol:
            maxCol = curCol
            maxIdx = j
    for i in h:
        for j in w:
            if j != maxIdx:
                image[i][j] = 0


def extractRow(image, w, h):
    maxRow = 0
    maxIdx = 0
    for i in h:
        curRow = sum(val >= darkest_point * 15 / 100 for val in image[i])
        if curRow > maxRow:
            maxRow = curRow
            maxIdx = i
    for i in h:
        if i != maxIdx:
            image[i] = [0]*w

def extractSevenSegmentDigit(image):
    # Divide digit in 3 row-wise sections, 2 col.
    # Find the max horizontal/vertical bar in region and remove rest.

    printGrid(image)
    h = len(image)
    w = len(image[0])


    colImage = [val[:] for val in image]
    rowImage = [val[:] for val in image]

    printDigit()
    extractCol(colImage, range(w//2), range(h//2))
    extractCol(colImage, range(w//2), range(h//2, h))
    extractCol(colImage, range(w//2, w), range(h//2))
    extractCol(colImage, range(w//2, w), range(h//2, h))

    #for i in range(height):
    #    for j in range(width//3, width*2//3):
    #        colImage[i][j] = 0

    extractRow(rowImage, w, range(h//5))
    extractRow(rowImage, w, range(h*2//5, h*3//5))
    extractRow(rowImage, w, range(h*4//5, h))
    for i in range(h//5, h*2//5): rowImage[i] = [0] * w
    for i in range(h*3//5, h*4//5): rowImage[i] = [0] * w
    #printGrid(rowImage)
    colImage = removeIslands(colImage, height//4)
    #rowImage = removeIslands(rowImage, 4)

    for i in range(h):
        for j in range(w):
            image[i][j] = colImage[i][j] or rowImage[i][j]

    printGrid(colImage)
    #printGrid(rowImage)
    #printGrid(image)
    time.sleep(0.2)


def findDigitBySegment(segment):
    if not segment[4] and not segment[6] and not segment[2] and segment[5] and segment[0]:
        return 4
    return -1



def printInputDigit():
    print()
    print("============================ DIGIT =========================")
    for i in range(28):
        for j in range(28):
            if inputImg[i][j] >= darkest_point * 15 / 100:
                print("#", end="")
            else:
                print(" ", end="")
        print()
    print("===========================================================")
    print()

def printDigit():
    print()
    print("============================ DIGIT =========================")
    for i in range(rMin, rMax+1):
        for j in range(cMin, cMax+1):
            if inputImg[i][j] >= darkest_point * 15 / 100:
                print("#", end="")
            else:
                print(" ", end="")
        print()
    print("===========================================================")
    print()


def printGrid(grid):
    if len(grid) == 0:
        return
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            print("&" if grid[i][j] else " ", end="")
        print()
    print()


def eraseLeftBorder(image, rightContour):
    for r, c in enumerate(rightContour):
        while c>= 0 and image[r][c] >= darkest_point * 15 / 100:
            c -= 1
        while c>=0:
            image[r][c] = 0
            c -= 1
    return image


"""