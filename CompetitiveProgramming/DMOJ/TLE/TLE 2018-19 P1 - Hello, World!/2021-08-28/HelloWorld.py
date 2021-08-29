import sys, random, collections, time
input = sys.stdin.readline

MAX = 28
rMin, cMin = 0, 0
rMax, cMax = MAX-1, MAX-1
width, height = 28, 28

dir8 = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
dir4 = [(-1, 0), (0, 1), (1, 0), (0, -1)]
dirTopLeft = [(-1, 0), (0, -1)]
dirTopRight = [(-1, 0), (0, 1)]
dirBotLeft = [(1, 0), (0, -1)]
dirBotRight = [(1, 0), (0, 1)]

darkCount = 0

# Finds the max length of a line segment in a section of an image.
def maxLength(image, h1, h2, w1, w2, dr, dc):
    maxCount = 0
    for i in range(h1, h2):
        for j in range(w1, w2):
            r, c = i, j
            count = image[r][c] >= darkest_point * 15 / 100
            while 1:
                if r < h1 or r >= h2 or c < w1 or c >= w2:
                    break
                if image[r][c] >= darkest_point * 15 / 100:
                    count += 1
                    maxCount = max(maxCount, count)
                else:
                    count = 0

                r += dr
                c += dc
    return maxCount

def digitToSevenSegment(image):
    segment = [0] * 7
    # 0: col upper left
    # 1: col upper right
    # 2: col lower left
    # 3: col lower right
    # 4: row top
    # 5: row mid
    # 6: row bot

    h = len(image)
    w = len(image[0])

    wSeptum = w//2
    col1 = max(maxLength(image, 0, h//2, 0, wSeptum, 1, 0), maxLength(image, 0, h//2, 0, wSeptum, 1, -1))
    col2 = max(maxLength(image, 0, h//2, wSeptum, w, 1, 0), maxLength(image, 0, h//2, wSeptum, w, 1, -1))
    col3 = max(maxLength(image, h//2, h, 0, wSeptum, 1, 0), maxLength(image, h//2, h, 0, wSeptum, 1, -1))
    col4 = maxLength(image, h//2, h, wSeptum, w, 1, 0)

    row1 = maxLength(image, 0, h//3, 0, w, 0, 1)
    row2 = maxLength(image, h//3, h*2//3, 0, w, 0, 1)
    row3 = maxLength(image, h*2//3, h, 0, w, 0, 1)

    if col1 > 7: segment[0] = 1
    if col2 > 7: segment[1] = 1
    if col3 > 7: segment[2] = 1
    if col4 > 7: segment[3] = 1
    if row1 > 8: segment[4] = 1
    if row2 > 8: segment[5] = 1
    if row3 > 8: segment[6] = 1
    return segment

def removeIslands(image, length): # Remove outliers
    h = len(image)
    w = len(image[0])

    vis = [[0]*w for _ in range(h)]
    for i in range(h):
        for j in range(w):
            if not vis[i][j] and image[i][j] >= darkest_point * 15 / 100:
                coord = set()
                vis[i][j] = 1
                coord.add((i, j))
                stack = [(i, j)]
                while stack:
                    x, y = stack.pop()
                    for d in dir4:
                        r, c = x+d[0], y+d[1]
                        if r>=0 and c>=0 and r<h and c<w and not vis[r][c] and image[r][c] >= darkest_point * 15 / 100:
                            vis[r][c] = 1
                            coord.add((r, c))
                            stack.append((r, c))
                if len(coord) <= length and len(coord) > 0:
                    for x, y in coord:
                        image[x][y] = 0
    return image


def crop(tolerance):
    global rMin, rMax, cMin, cMax, height, width
    leftIdx = []
    rightIdx = []
    upIdx = []
    downIdx = []

    for i in range(MAX):
        for j in range(MAX):
            if inputImg[i][j] >= darkest_point * tolerance:
                leftIdx.append(j)
                break
        for j in reversed(range(MAX)):
            if inputImg[i][j] >= darkest_point * tolerance:
                rightIdx.append(j)
                break
    for i in range(MAX):
        for j in range(MAX):
            if inputImg[j][i] >= darkest_point * tolerance:
                upIdx.append(j)
                break
        for j in reversed(range(MAX)):
            if inputImg[j][i] >= darkest_point * tolerance:
                downIdx.append(j)
                break
    rMin = min(upIdx)
    rMax = max(downIdx)
    cMin = min(leftIdx)
    cMax = max(rightIdx)

    height = rMax-rMin+1
    width = cMax-cMin+1

def printImage(image):
    print()
    print("============================ IMAGE =========================")
    if len(image) == 0:
        return
    for i in range(len(image)):
        for j in range(len(image[0])):
            print("&" if image[i][j] >= darkest_point * 15 / 100 else " ", end="")
        print()
    print("===========================================================")
    print()

def divideList(xs, n):
    ls = len(xs)
    size = [ls//n] * n
    for i in range(ls % n):
        size[i] += 1
    if size[0] != size[-1]:
        size[0] -= 1
        size[n//2] += 1
    
    avg = []
    copy = [ls//n] * n
    for i in range(1, len(copy)):
        copy[i] += copy[i-1]
    for i in range(ls % n):
        for j in range(i+1, len(copy)):
            copy[j] += 1
    a = 0
    for i in copy:
        b = a + ls//n
        if b-a == 0:
            continue
        avg.append(sum(xs[a:b])/(b-a))
        a = b

    """
    avg = []
    a = 0
    for i in size:
        b = a + i
        avg.append(sum(xs[a:b])/(b-a))
        #print(a, b, "A B")
        a = b
    print(avg)
    """
    return avg

def lineAreaPercent():
    global darkCount
    count = 0
    for i in range(height):
        for j in range(width):
            if img[i][j] >= darkest_point * 15 / 100:
                count += 1
    darkCount = count
    return count * 100 / (width*height)

def solidAreaPercent():
    neg = 0
    stop = [width] * height
    for i in range(height):
        for j in range(width):
            if img[i][j] >= darkest_point * 15 / 100:
                stop[i] = j
                break
            neg += 1
    for i in range(height):
        for j in range(width-1, stop[i], -1):
            if img[i][j] >= darkest_point * 15 / 100:
                break
            neg += 1

    area = width*height
    pos = area - neg
    return pos * 100 / area

def middleConnect():
    # check if can walk from left 1/3 to right 1/3 column wise through middle 1/3 row wise.
    # For 9 and 7 differentiation.
    
    # row start, row end
    rs = height // 3
    re = height * 1 // 2

    # Col start start, col start end
    css = 0
    cse = width // 3
    ces = width * 2//3
    cee = width

    vis = [[0]*width for _ in range(height)]
    for i in range(rs, re):
        for j in range(css, cse):
            if img[i][j] >= darkest_point * 15 / 100:
                vis[i][j] = 1
                stack = [(i, j)]
                while stack:
                    x, y = stack.pop()
                    for d in [(0, 1), (1, 0), (-1, 0)]:
                        r, c = x+d[0], y+d[1]
                        if r>=rs and c>=0 and r<re and c<width and not vis[r][c] and img[r][c] >= darkest_point * 15 / 100:
                            vis[r][c] = 1
                            stack.append((r, c))

                            if c >= ces:
                                return True
    return False

def topLeftConnect():
    # row start, row end
    rss = 0
    rse = height * 1 // 4
    res = height * 2 // 5
    ree = height * 1 // 2

    # Col start start, col start end
    cs = 0
    ce = width *2// 3

    vis = [[0]*width for _ in range(height)]

    for j in range(cs, ce):
        for i in range(rss, rse):
            if img[i][j] >= darkest_point * 15 / 100:
                vis[i][j] = 1
                stack = [(i, j)]
                while stack:
                    x, y = stack.pop()
                    for d in [(1, 0), (0, 1), (0, -1)]:
                        r, c = x+d[0], y+d[1]
                        if r>=rss and c>=cs and r<ree and c<ce and not vis[r][c] and img[r][c] >= darkest_point * 15 / 100:
                            vis[r][c] = 1
                            stack.append((r, c))

                            if r >= res:
                                return True
    return False

def walkNumberNine(image, leftContour):
    # Walk left down, then right up, then left down. if reach bottom 1/8th return true. Premature reach = return false.
    h = len(image)
    w = len(image[0])

    # Remove bar after 9 upper hole to prevent walking down prematurely.
    for r, c in enumerate(leftContour[:h//4]):
        while c<w and image[r][c] >= darkest_point * 15 / 100:
            c += 1
        for j in range(c, w):
            image[r][j] = 0
    

    vis = [[0]*w for _ in range(h)]
    # Walk to hole left corner.
    stack = [(0, leftContour[0])]
    vis[0][leftContour[0]] = 1
    while stack:
        x1, y1 = stack.pop()
        for d in [(1, 0), (0, -1)]:
            x2, y2 = x1+d[0], y1+d[1]
            if x2>=0 and y2>=0 and x2<h and y2<w and not vis[x2][y2] and image[x2][y2] >= darkest_point * 15 / 100:
                vis[x2][y2] = 1
                stack.append((x2, y2))

                if x2 > h*7/8:
                    return False
    
    #Visit right branch top bar for count.
    stack = [(0, leftContour[0])]
    vis[0][leftContour[0]] = 1
    while stack:
        x1, y1 = stack.pop()
        for d in [(1, 0), (0, 1)]:
            x2, y2 = x1+d[0], y1+d[1]
            if x2>=0 and y2>=0 and x2<h and y2<w and not vis[x2][y2] and image[x2][y2] >= darkest_point * 15 / 100:
                vis[x2][y2] = 1
                stack.append((x2, y2))

    # Find starting point of next walk.
    for i in reversed(range(h)):
        for j in reversed(range(w-1)):
            if vis[i][j] and not vis[i][j+1] and image[i][j+1] >= darkest_point * 15 / 100:
                break
        else:
            continue
        break
    checkpoint1 = (i, j)

    # Walk to top right.
    stack = [(i, j)]
    vis[i][j] = 1
    while stack:
        x1, y1 = stack.pop()
        for d in [(-1, 0), (0, 1)]:
            x2, y2 = x1+d[0], y1+d[1]
            if x2>=0 and y2>=0 and x2<h and y2<w and not vis[x2][y2] and image[x2][y2] >= darkest_point * 15 / 100:
                vis[x2][y2] = 1
                stack.append((x2, y2))

    # Find start of next walk.
    for j in reversed(range(w)):
        for i in reversed(range(h-1)):
            if vis[i][j] and not vis[i+1][j] and image[i+1][j] >= darkest_point * 15 / 100:
                break
        else:
            continue
        break
    checkpoint2 = (i, j)

    # Walk to bottom left.
    stack = [(i, j)]
    vis[i][j] = 1
    maxRow = 0
    while stack:
        x1, y1 = stack.pop()
        for d in [(1, 0), (0, -1), (0, 1)]:
            x2, y2 = x1+d[0], y1+d[1]
            if x2>=0 and y2>=0 and x2<h and y2<w and not vis[x2][y2] and image[x2][y2] >= darkest_point * 15 / 100:
                vis[x2][y2] = 1
                maxRow = max(maxRow, x2)
                stack.append((x2, y2))
    
    if maxRow > h*7/8:
        # Count number of unvisited cells.
        count = 0
        for i in range(h):
            for j in range(w):
                if image[i][j] >= darkest_point * 15 / 100 and not vis[i][j]:
                    count += 1

        if count >= 6: # Left hook, e.g., 5, 8.
            return False

        if checkpoint1[0] >= 10:
            if checkpoint1[1] <= 2:
                return True
    return False

def findSandwich(r, t): # row, thickness
    c = 0
    for i in range(width):
        if img[r][i] >= darkest_point * 15 / 100:
            c += 1
        else:
            if c >= t:
                break
            c = 0
    return i

passStage1 = 0
def upperBarSandwich():
    global passStage1
    # blank space sandwitched between straight bars, empty space identical by relative diff of 1, for >=5 consecutive rows.
    rowData = [[0]*3 for _ in range(height*2//3)]
    for r in range(height*2//3):
        c = 0
        count = 0
        left = 0
        right = 0

        # Find left bar
        while c<width and img[r][c] < darkest_point * 15 / 100:
            c += 1
        while c<width and img[r][c] >= darkest_point * 15 / 100: # Inner side
            c += 1
        left = c
        # Add to right 
        while c<width and img[r][c] < darkest_point * 15 / 100:
            c += 1
            count += 1
        right = c

        if c != width:
            rowData[r] = [count, left, right]

    openingWidth = 29
    passStage1 = 0
    count = 0
    start = 0
    for i in range(len(rowData)-1):
        rowWidth = rowData[i][0]
        left = rowData[i][1]
        right = rowData[i][2]

        if rowWidth != 0 and abs(rowWidth - rowData[i+1][0]) <= 1:
            openingWidth = min(openingWidth, rowWidth)
            count += 1
            if count > 2:
                passStage1 = 1
                start = i-2
                break
        else:
            count = 0
            openingWidth = 29

    if not passStage1:
        return False

    leftWidth = -99999
    rightWidth = -99999
    midWidth = -99999
    
    # USEFUL VARIABLES: start, openingWidth
    for i in range(start):
        # If row width < open width return false
        # row width is 0 to left of bar, or width-1 to right of bar
        leftWidth = 0
        for j in range(width):
            if img[i][j] >= darkest_point * 15 / 100:
                leftWidth = j
                break
        left = j
        while left<width and img[i][left] >= darkest_point * 15 / 100:
            left += 1

        rightWidth = 0
        for j in reversed(range(width)):
            if img[i][j] >= darkest_point * 15 / 100:
                rightWidth = width - j - 1
                break
        right = j
        while right>=0 and img[i][right] >= darkest_point * 15 / 100:
            right -= 1

        for j in range(left, right+1):
            if img[i][j] >= darkest_point * 15 / 100:
                return False
        midWidth = right-left + 1

        if leftWidth*100/openingWidth < 85 and rightWidth*100/openingWidth < 85 and midWidth*100/openingWidth < 60:
            return False

    # Walk up to check opening
    r = start
    c = 0
    while c<width and img[r][c] < darkest_point * 15 / 100:
        c += 1
    while c<width and img[r][c] >= darkest_point * 15 / 100:
        c += 1
    vis = [[0]*width for _ in range(height)]
    dir = [(-1, 0), (0, -1), (0, 1)]
    vis[r][c] = 1
    stack = [(r, c)]
    while stack:
        x, y = stack.pop()
        for d in dir:
            x2, y2 = x+d[0], y+d[1]
            if x2>=0 and y2>=0 and x2<height and y2<width and not vis[x2][y2] and img[x2][y2] < darkest_point * 15 / 100:
                vis[x2][y2] = 1
                stack.append((x2, y2))
    found = 0
    for i in range(width):
        if vis[0][i]:
            found = 1
            break
    if not found:
        return False
    
    # Check down for correct closing.
    col = 0
    while col<width and img[start][col] < darkest_point * 15 / 100:
        col += 1
    while col<width and img[start][col] >= darkest_point * 15 / 100:
        col += 1

    vis = set([(start, col)])
    stack = [(start, col)]
    sx, sy = 0, 0
    while stack:
        x, y = stack.pop()
        for d in [(1, 0), (0, 1), (0, -1)]:
            r, c = x+d[0], y+d[1]
            if (r, c) not in vis and r<height and c<width and img[r][c] < darkest_point * 15 / 100:
                if r > sx:
                    sx, sy = r, c
                vis.add((r, c))
                stack.append((r, c))
    
    if sx == 0 and sy == 0:
        return False
    
    # Walk down
    downRow = sx+1
    while downRow<height and img[downRow][sy] >= darkest_point * 15 / 100:
        downRow += 1

    # Walk diagonal
    leftDownRow = sx+1
    while leftDownRow<height and sy>=0 and img[leftDownRow][sy] >= darkest_point * 15 / 100:
        leftDownRow += 1
        sy -= 1
    
    bestRow = min(downRow, leftDownRow)

    if bestRow > height * 10 // 11:
        return False
    return True

def visit(vis, x0, y0, dir, visitDark=False):
    if not visitDark and img[x0][y0] >= darkest_point * 15 / 100:
        return vis

    vis[x0][y0] = 1
    stack = [(x0, y0)]
    while stack:
        x, y = stack.pop()
        for d in dir:
            r, c = x+d[0], y+d[1]
            if r>=0 and c>=0 and r<height and c<width and not vis[r][c]:
                if not visitDark:
                    if img[r][c] < darkest_point * 15 / 100:
                        vis[r][c] = 1
                        stack.append((r, c))
                else:
                    if img[r][c] >= darkest_point * 15 / 100:
                        vis[r][c] = 1
                        stack.append((r, c))
    return vis

def findHoles(dir):
    holeIdx = []

    # Visit from all borders.
    vis = [[0]*width for _ in range(height)]
    for i in range(0, width):
        vis = visit(vis, 0, i, dir)
    for i in range(0, height):
        vis = visit(vis, i, 0, dir)
    for i in range(0, width):
        vis = visit(vis, height-1, i, dir)
    for i in range(0, height):
        vis = visit(vis, i, width-1, dir)

    # Loop through unvisited to find hole count.
    holes = 0
    area = []
    for i in range(height):
        for j in range(width):
            if not vis[i][j] and img[i][j] < darkest_point * 15 / 100:
                before = sum([v.count(1) for v in vis])
                holeIdx.append((i, j))
                visit(vis, i, j, dir)
                after = sum([v.count(1) for v in vis])
                holes += 1
                area.append(after-before)
    return holes, area, holeIdx

def linearToTopRight():
    vis = [[0]*width for _ in range(height)]
    dir = [(1, 0), (0, -1)]
    exit = 0
    for i in reversed(range(width)):
        for j in range(height):
            if img[j][i] >= darkest_point * 15 / 100:
                exit = 1
                vis = visit(vis, j, i, dir, visitDark=True)
        if exit:
            break
    row = j
    col = i

    for i in range(row):
        for j in range(col):
            if img[i][j] >= darkest_point * 15 / 100 and not vis[i][j]:
                return False
    return True

def linearToTopLeft():
    vis = [[0]*width for _ in range(height)]
    dir = [(-1, 0), (0, -1)]
    exit = 0
    for i in reversed(range(width)):
        for j in range(height):
            if img[j][i] >= darkest_point * 15 / 100:
                exit = 1
                vis = visit(vis, j, i, dir, visitDark=True)
        if exit:
            break
    row = j
    col = i

    count = 0
    for i in range(row):
        for j in range(col):
            if img[i][j] >= darkest_point * 15 / 100 and not vis[i][j]:
                count += 1
    if count > 0:
        return False
    else:
        return True

def diagonalTopRight(top, bot):
    touch = 0
    for i in range(1, len(top)):
        if top[i] == 0:
            touch = 1
        if not( top[i-1] > top[i] or abs(top[i-1] - top[i]) <= 2 ) or touch and top[i] > 2:
            return False
    touch = 0
    for i in range(1, len(bot)):
        if bot[i] == height-1:
            touch = 1
        if not( bot[i-1] > bot[i] or abs(bot[i-1] - bot[i]) <= 2 )  or not touch and height - bot[i] > 2:
            return False
    return True

def containsDiagonal():
    for i in reversed(range(height)):
        for j in range(width):
            if img[i][j] >= darkest_point * 15 / 100:
                break
    dir = [(-1, 0), (0, 1)]
    stack = [(i, j)]
    while stack:
        x, y = stack.pop()
        for d in dir:
            r, c = x+d[0], y+d[1]
            if r>=0 and c<width and img[r][c] >= darkest_point * 15 / 100:
                stack.append((r, c))
                if r <= height//4 and c >= width*3//4:
                    return True
    return False

def zeroBotLeftDiagonal(holeIdx):
    sx, sy = holeIdx[0]

    # Walk to bottom left from top left point in hole. Removes 9
    stack = [(sx, sy-1)]
    while stack:
        x, y = stack.pop()
        for d in dirBotLeft:
            r, c = x+d[0], y+d[1]
            if r >=0 and c<width and c>=0 and r<height and img[r][c] >= darkest_point * 15 / 100:
                stack.append((r, c,))
                if r >= height *7 // 8 and c <= width//4:
                    return True
    return False

def zeroPositiveDiagonal(holeIdx):
    if not zeroBotLeftDiagonal(holeIdx):
        return False
                    
    # Walk to top right from right-most point in hole. Removes 6
    sx, sy = holeIdx[0]
    stack = [holeIdx[0]]
    vis = set()
    while stack: # Find top right inside hole.
        x, y = stack.pop()
        for d in dirBotRight:
            r, c = x+d[0], y+d[1]
            if (r,c) not in vis and r>=0 and c <width and r < height and c >=0 and img[r][c] < darkest_point * 15 / 100:
                vis.add((r, c))
                stack.append((r, c))
                if c > sy:
                    sx, sy = r, c 
    
    stack = [(sx, sy+1)]
    while stack: # Find top right of border.
        x, y = stack.pop()
        for d in dirTopRight:
            r, c = x+d[0], y+d[1]
            if r>=0 and c <width and img[r][c] >= darkest_point * 15 / 100:
                stack.append((r, c))
                if r <= height // 8 and c >= width*3 //4:
                    return True
    return False
        

def widthFrequency():
    widths = []
    for i in range(height):
        count = 0
        for j in range(width):
            if img[i][j] >= darkest_point * 15 / 100:
                count += 1
        widths.append(count)
    
    freq = [0] * 29
    for w in widths:
        freq[w] += 1
    return freq

def findWidthFreqLengths(widthFreq):
    groups = []
    count = 0
    for w in widthFreq:
        if w == 0:
            if count > 0:
                groups.append(count)
                count = 0
        else:
            count += 1
    return groups

def findHoleLengths():
    holes = []
    for i in range(height):
        y = findSandwich(i, 1)
        idx = y
        end = 1
        for j in range(y, width):
            if img[i][j] >= darkest_point * 15 / 100:
                break
            idx = j
        if idx != width-1:
            end = 0
        for j in range(y, -1, -1):
            if img[i][j] >= darkest_point * 15 / 100:
                break
            idx = j
        if img[i][y] < darkest_point * 15 / 100 and idx != 0 and not end:
            # Check up down.
            for j in range(i, -1, -1):
                if img[j][y] > darkest_point * 15 / 100:
                    break
            if j == 0:
                continue
            holes.append(i)
    length = 1
    lengths = []
    for i in range(1, len(holes)):
        if holes[i] <= holes[i-1]+3:
            length += 1
        else:
            lengths.append(length)
            length = 0
    if length != 0:
        lengths.append(length)
    return lengths, holes


def upperCrescent():
    # Differentiate 7 and 9.
    # 9 has crescent in upper half of digit whether enclosed or not.
    # if not starting at dark move to dark
    # Band 1: full travel dark to empty.
        # 7 usually at end of top bar
        # 9 usually at top of hole
    # Full travel down, empty to dark.
        # 7: reached the vertical bar
        # 9: bottom of hole
    # band 2: Full travel down, dark to empty.
        # 7: bottom border of vertical bar
        # 9: bottom border of hole
    # if index at height*7//8 to height, return false

    for c in range(width//2):
        r = 0

        while r<height and img[r][c] < darkest_point * 15 / 100:
            r += 1
        while r<height and img[r][c] >= darkest_point * 15 / 100: # Band 1
            r += 1
        while r<height and img[r][c] < darkest_point * 15 / 100: # End hole bot
            r += 1
        while r<height and img[r][c] >= darkest_point * 15 / 100: # Band 2
            r += 1
        if r < height*7//8:
            return True
    return False

def identityCresent():
    # Same as upperCrescent except the starting point and direction of check:
    # start at top right corner, check diagonal down
    # Endpoint should be within 2/3 height,
    # Named after the real number identity function f(x) = x.
    for c in range(width*4//5, width):
        for r in range(height//8):
            while r<height and c>=0 and img[r][c] < darkest_point * 15 / 100:
                r += 1
                c -= 1
            while r<height and c>=0 and img[r][c] >= darkest_point * 15 / 100: # Band 1
                r += 1
                c -= 1
            while r<height and c>=0 and img[r][c] < darkest_point * 15 / 100: # End hole bot
                r += 1
                c -= 1
            while r<height and c>=0 and img[r][c] >= darkest_point * 15 / 100: # Band 2
                r += 1
                c -= 1
            if r < height*2//3:
                return True
    return False

def doubleLoop():
    # for 8
    for c in range(width*3//8, width*6//8):
        r = 0

        while r<height and img[r][c] < darkest_point * 15 / 100:
            r += 1
        if r == height:
            continue

        while r<height and img[r][c] >= darkest_point * 15 / 100: # Band 1
            r += 1
        if r == height:
            continue

        while r<height and img[r][c] < darkest_point * 15 / 100: # End hole bot
            r += 1
        if r == height:
            continue

        while r<height and img[r][c] >= darkest_point * 15 / 100: # Band 2
            r += 1
        if r == height:
            continue

        while r<height and img[r][c] < darkest_point * 15 / 100: # End hole bot 2
            r += 1
        if r == height:
            continue

        while r<height and img[r][c] >= darkest_point * 15 / 100: # Band 3
            r += 1
        
        if r >= height-2:
            return True
    return False

def createCircle(innerRadius, outerRadius):
    innerDiameter = innerRadius * 2
    outerDiameter = outerRadius * 2
    
    circle = [[1]*(outerDiameter+1) for _ in range(outerDiameter+1)]

    cx, cy = outerRadius, outerRadius

    for i in range(0, outerDiameter+1):
        for j in range(0, outerDiameter+1):
            dx = abs(i-cx)
            dy = abs(j-cy)
            if (dx ** 2 + dy ** 2) ** 0.5 < innerRadius:
                circle[i][j] = 0
            if (dx ** 2 + dy ** 2) ** 0.5 > outerRadius:
                circle[i][j] = 0
    return circle

def printCircle(circle):
    for c in circle:
        for cc in c:
            print("#" if cc else " ", end = "")
        print()
    print()

def circleArea(circle):
    area = 0
    for i in range(len(circle)):
        for j in range(len(circle)):
            if circle[i][j]:
                area += 1
    return area

def matchCircle(circle, startRow = 0):
    matches = [(-1, -1, -1)] # (match count, i, j)

    outerRadius = len(circle)//2
    outerDiameter = outerRadius * 2
    area = circleArea(circle)
    if not area:
        return 0

    for r in range(startRow, height-outerDiameter):
        for c in range(width-outerDiameter):
            count = 0
            for i in range(outerDiameter):
                for j in range(outerDiameter):
                    if circle[i][j] and img[i+r][j+c] >= darkest_point * 15 / 100:
                        count += 1
            matches.append((count*100/area, r+outerRadius, c+outerRadius))
    matches.sort(reverse=True)
    return matches
    
def arc(innerRadius, outerRadius, rowRange, colRange):
    arc = createCircle(innerRadius, outerRadius)
    for i in rowRange:
        for j in colRange:
            arc[i][j] = 0
    #printCircle(arc)
    return arc

def arcW(innerRadius, outerRadius, depth=None):
    if depth == None: depth = outerRadius - innerRadius + 1
    return arc(innerRadius, outerRadius, range(outerRadius*2+1), range(depth))

def arcE(innerRadius, outerRadius, depth=None):
    if depth == None: depth = outerRadius - innerRadius + 1
    return arc(innerRadius, outerRadius, range(outerRadius*2+1), range(outerRadius*2+1-depth, outerRadius*2+1))

def arcN(innerRadius, outerRadius, depth=None):
    if depth == None: depth = outerRadius - innerRadius + 1
    return arc(innerRadius, outerRadius, range(depth), range(outerRadius*2+1))

def arcS(innerRadius, outerRadius, depth=None):
    if depth == None: depth = outerRadius - innerRadius + 1
    return arc(innerRadius, outerRadius, range(outerRadius*2+1-depth, outerRadius*2+1), range(outerRadius*2+1))

def matchArcW(startRow=0):
    return matchCircle(arcW(3, 5))

def getGridCount(grid):
    count = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j]:
                count += 1
    return count

def getImgMatchCount(grid):
    if len(grid) != len(img) or len(grid[0]) != len(img[0]):
        return
    count = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] and img[i][j] >= darkest_point * 15 / 100:
                count += 1
            if not grid[i][j] and img[i][j] < darkest_point * 15 / 100:
                count += 1
    return count

def quadrant24(leftContour, rightContour, barWidth=3, tunnelHeight=5):
    allowed = [[1 if img[i][j] >= darkest_point * 15 / 100 else 0 for j in range(width)] for i in range(height)] # Match image.

    # CHANGE METHOD: find left with right contour, travel two vertical bands *IF* position incorrect relative to width//2
    # Because may confuse 9 base segment as X line.

    # Restrict top right.
    topSector = []
    for i in range(height//2-tunnelHeight//2):
        for j in range(leftContour[i] + barWidth, width):
            allowed[i][j] = 0

        # Clean up columns after hole regardless of barWidth.
        j = leftContour[i]
        while j < width and img[i][j] >= darkest_point * 15 / 100:
            j += 1
        topSector.append(range(leftContour[i], j))
        for jj in range(j, width):
            allowed[i][jj] = 0

    # Bot left
    botSector = []
    for i in range(height //2 + tunnelHeight//2, height):
        botSector.append(range(rightContour[i]-barWidth, rightContour[i]+1))
        for j in range(rightContour[i]-barWidth):
            allowed[i][j] = 0
        j = rightContour[i]
        while j >= 0 and img[i][j] >= darkest_point * 15 / 100:
            j -= 1
        for jj in range(j):
            allowed[i][jj] = 0
    

    # start
    maxDist = 0
    for i in range(len(topSector)):
        for j in topSector[i]:
            if j>=0 and j<width and img[i][j] >= darkest_point * 15 / 100:
                dist = [[0]*width for _ in range(height)]
                stack = [(i, j)]
                while stack:
                    x, y = stack.pop()
                    for d in dirBotRight:
                        r, c = x+d[0], y+d[1]
                        if r<height and c<width and allowed[r][c] and dist[x][y]+1 > dist[r][c]:
                            dist[r][c] = dist[x][y] + 1
                            stack.append((r, c))

                idx = 0
                for ii in range(height // 2 + tunnelHeight // 2, height):
                    for jj in botSector[idx]:
                        maxDist = max(maxDist, dist[ii][jj])
                    idx += 1
    return maxDist


def matchX():
    quadrant24()
    # detect 8, of the digits 1234567890, 8 is the only one where X can be matched at acute angles at top and bot
    # Find the max length X bars , compare to width of image as alternative to angle calculation
    # X will be determined by direction of travel, to bottom right can only have bottom and right direction

    # Move from quadrant 2 -> 4, left branch
    # 1 -> right branch

def destroyLayers(image, layers):
    h = len(image)
    w = len(image[0])
    for _ in range(layers):
        copy = [[0]*w for _ in range(h)]
        for i in range(h):
            copy[i][0] = 0
            copy[i][-1] = 0
            for j in range(1, w-1):
                copy[i][j] = int(image[i][j-1] >= darkest_point * 15 / 100 and image[i][j+1] >= darkest_point * 15 / 100)
        image = copy

    count = 0
    for i in range(h):
        count += sum(image[i])
    return (count, image)


def leftPinch(left):
    global ma
    # Check top down, bottom up, interquartile range on both left and right side.
    a = 0
    b = height-1
    # Dynamic row start and end point, where local max marks a, b. If next row < cur, cur = local max, else go next.
    for i in range(1, height):
        if left[i] > left[a]:
            break
        else:
            a = i
    for i in reversed(range(height-1)):
        if left[i] > left[b]:
            break
        else:
            b = i

    # Dynamic midpoint, check if mid from bot up, top down is equal, if so, converge.
    ma = a
    for i in range(a, b):
        if left[i+1] < left[i]:
            ma = i
            # print("break ma", i, left[i+1], left[i])
            break
    mb = b
    for i in reversed(range(a, b)):
        if left[i-1] < left[i]:
            mb = i
            break

    return not( left[ma] - left[a] == 0 and left[mb] - left[b] == 0 )
    return abs(left[ma] - left[mb]) <= 1

ma = 0
def rightPinch(right):
    global ma
    # Check top down, bottom up, interquartile range on both left and right side.
    a = 0
    b = height-1
    # Dynamic row start and end point, where local max marks a, b.
    for i in range(1, height):
        if right[i] < right[a]:
            break
        else:
            a = i
    for i in reversed(range(height-1)):
        if right[i] < right[b]:
            break
        else:
            b = i

    # Dynamic midpoint, check if mid from bot up, top down is equal, if so, converge.
    ma = a
    for i in range(a, b):
        if right[i+1] > right[i]:
            ma = i
            break
    mb = b
    for i in reversed(range(a, b)):

        if right[i-1] > right[i]:
            mb = i
            break
    
    return abs(right[ma] - right[mb]) <= 1

def middlePinch(left, right):
    return leftPinch(left) or rightPinch(right)

def leftContours(image):
    idx = [0] * height
    for i in range(height):
        for j in range(width):
            if image[i][j] >= darkest_point * 15 / 100:
                idx[i] = j
                break
    return idx

def rightContours():
    idx = [width-1] * height
    for i in range(height):
        for j in reversed(range(width)):
            if img[i][j] >= darkest_point * 15 / 100:
                idx[i] = j
                break
    return idx

def topContours():
    idx = [0] * width
    for i in range(width):
        for j in range(height):
            if img[j][i] >= darkest_point * 15 / 100:
                idx[i] = j
                break
    return idx

def botContours():
    idx = [height-1] * width
    for i in range(width):
        for j in reversed(range(height)):
            if img[j][i] >= darkest_point * 15 / 100:
                idx[i] = j
                break
    return idx

def firstDiff(data):
    for i in reversed(range(1, len(data))):
        data[i] -= data[i-1]
    
    if len(data) == 1:
        return [-999]
    return data[1:]

def findConcavity(contour, filter):
    contour = [x for x in contour if x in filter]
    group = []
    sum = 0
    for v in contour:
        if v < 0:
            if sum > 0:
                group.append(sum)
                sum = 0
        else:
            if sum < 0:
                group.append(sum)
                sum = 0
        sum += v
    if sum != 0:
        group.append(sum)
    return group

def copy2D(data):
    return [v[:] for v in data]

def rAvgSolidCalc(leftContour, rightcontour):
    return [(1+rightcontour[i]-leftContour[i])*100/width for i in range(height)]
def cAvgSolidCalc(topContour, botContour):
    return [(1+botContour[i]-topContour[i])*100/height for i in range(width)]

def findDigit():
    processHolesStrict = findHoles(dir8)
    nHolesStrict = processHolesStrict[0]
    holeAreaStrict = processHolesStrict[1]
    holeIdxStrict = processHolesStrict[2]

    processHoles = findHoles(dir4)
    nHoles = processHoles[0]
    holeArea = processHoles[1]
    holeIdx = processHoles[2]

    lineArea = lineAreaPercent()
    solidArea = solidAreaPercent()
    oneHoleSolidArea = 0 if len(holeArea) == 0 else (darkCount + holeArea[0]) * 100 / (width * height)
    twoHoleSolidArea = 0 if len(holeArea) <= 1 else (darkCount + holeArea[0] + holeArea[1]) * 100 / (width * height)

    leftContour = leftContours(img)
    rightContour = rightContours()
    topContour = topContours()
    botContour = botContours()

    left_contours_diff_1 = firstDiff(leftContour[:])
    right_contours_diff_1 = firstDiff(rightContour[:])
    top_contours_diff_1 = firstDiff(topContour[:])
    bot_contours_diff_1 = firstDiff(botContour[:])

    max_left_diff = max(left_contours_diff_1, key=abs)
    max_right_diff = max(right_contours_diff_1, key=abs)
    max_top_diff = max(top_contours_diff_1, key=abs)
    max_bot_diff = max(bot_contours_diff_1, key=abs)
    
    left_contours_diff_2 = firstDiff(left_contours_diff_1)
    right_contours_diff_2 = firstDiff(right_contours_diff_1)
    top_contours_diff_2 = firstDiff(top_contours_diff_1)
    bot_contours_diff_2 = firstDiff(bot_contours_diff_1)

    max_left_diff_2 = max(left_contours_diff_2, key=abs)
    max_right_diff_2 = max(right_contours_diff_2, key=abs)
    max_top_diff_2 = max(top_contours_diff_2, key=abs)
    max_bot_diff_2 = max(bot_contours_diff_2, key=abs)

    rAvgSolid = rAvgSolidCalc(leftContour, rightContour)
    cAvgSolid = cAvgSolidCalc(topContour, botContour)

    rQuintileSolid = divideList(rAvgSolid, 5)
    max_row_solid_5 = max(rQuintileSolid)
    min_row_solid_5 = min(rQuintileSolid)
    range_row_solid_5 = max_row_solid_5 - min_row_solid_5
    avg_row_solid_5 = sum(rQuintileSolid) / 5
    hi_diff_solid_5 = max_row_solid_5 - avg_row_solid_5
    lo_diff_solid_5 = avg_row_solid_5 - min_row_solid_5
    max_rows_list_solid_5 = [x for x in rQuintileSolid if x >= max_row_solid_5 - 15]
    max_rows_solid_5 = len(max_rows_list_solid_5)

    rSixthSolid = divideList(rAvgSolid, 6)
    max_row_solid_6 = max(rSixthSolid)
    min_row_solid_6 = min(rSixthSolid)
    range_row_solid_6 = max_row_solid_6 - min_row_solid_6
    avg_row_solid_6 = sum(rSixthSolid) / 6
    hi_diff_solid_6 = max_row_solid_6 - avg_row_solid_6
    lo_diff_solid_6 = avg_row_solid_6 - min_row_solid_6
    max_rows_list_solid_6 = [x for x in rSixthSolid if x >= max_row_solid_6 - 15]
    max_rows_solid_6 = len(max_rows_list_solid_6)

    cThirdsSolid = divideList(cAvgSolid, 3)
    max_col_solid_3 = max(rQuintileSolid)
    min_col_solid_3 = min(rQuintileSolid)
    range_col_solid_3 = max_col_solid_3 - min_col_solid_3
    avg_col_solid_3 = sum(rQuintileSolid) / 5
    hi_diff_solid_3 = max_col_solid_3 - avg_col_solid_3
    lo_diff_solid_3 = avg_col_solid_3 - min_col_solid_3
    max_cols_list_solid_3 = [x for x in rQuintileSolid if x >= max_col_solid_3 - 15]
    max_cols_solid_3 = len(max_cols_list_solid_3)

    cQuintileSolid = divideList(cAvgSolid, 5)
    max_col_solid_5 = max(rQuintileSolid)
    min_col_solid_5 = min(rQuintileSolid)
    range_col_solid_5 = max_col_solid_5 - min_col_solid_5
    avg_col_solid_5 = sum(rQuintileSolid) / 5
    hi_diff_solid_5 = max_col_solid_5 - avg_col_solid_5
    lo_diff_solid_5 = avg_col_solid_5 - min_col_solid_5
    max_cols_list_solid_5 = [x for x in rQuintileSolid if x >= max_col_solid_5 - 15]
    max_cols_solid_5 = len(max_cols_list_solid_5)

    rowQuintile = divideList(rAvg, 5)
    max_row_5 = max(rowQuintile)
    min_row_5 = min(rowQuintile)
    avg_row_5 = sum(rowQuintile) / 5
    hi_diff_5 = max_row_5 - avg_row_5
    lo_diff_5 = avg_row_5 - min_row_5
    max_rows_list_5 = [x for x in rowQuintile if x >= max_row_5 - 15]
    max_rows_5 = len(max_rows_list_5)

    rowSixth = divideList(rAvg, 6)
    max_row_6 = max(rowSixth)
    min_row_6 = min(rowSixth)
    avg_row_6 = sum(rowSixth) / 6
    hi_diff_6 = max_row_6 - avg_row_6
    lo_diff_6 = avg_row_6 - min_row_6
    max_rows_list_6 = [x for x in rowSixth if x >= max_row_6 - 15]
    max_rows_6 = len(max_rows_list_6)

    rowEighth = divideList(rAvg, 8)
    max_row_8 = max(rowEighth)
    min_row_8 = min(rowEighth)
    avg_row_8 = sum(rowEighth) / 8
    hi_diff_8 = max_row_8 - avg_row_8
    lo_diff_8 = avg_row_8 - min_row_8
    max_rows_list_8 = [x for x in rowEighth if x >= max_row_8 - 15]
    max_rows_8 = len(max_rows_list_8)

    rowThird = divideList(rAvg, 3)
    max_row_3 = max(rowThird)
    min_row_3 = min(rowThird)
    avg_row_3 = sum(rowThird) / 3
    hi_diff_3 = max_row_3 - avg_row_3
    lo_diff_3 = avg_row_3 - min_row_3
    max_rows_list_3 = [x for x in rowThird if x >= max_row_3 - 15]
    max_rows_3 = len(max_rows_list_3)

    colHalf = divideList(cAvg, 2)
    max_col_2 = max(colHalf)
    min_col_2 = min(colHalf)
    max_cols_list_2 = [x for x in colHalf if x >= max_col_2 - 15]
    max_cols_2 = len(max_cols_list_2)

    colThird = divideList(cAvg, 3)
    max_col_3 = 0 if len(colThird) == 0 else max(colThird)
    min_col_3 = 0 if len(colThird) == 0 else  min(colThird)
    max_cols_list_3 = [x for x in colThird if x >= max_col_3 - 15]
    max_cols_3 = len(max_cols_list_3)

    holeVal = findHoleLengths()
    holeLengths = holeVal[0]
    holeIndex = holeVal[1]

    widthFreq = widthFrequency()
    widthFreqLengths = findWidthFreqLengths(widthFreq)

    segment = digitToSevenSegment(inputImg)

    right_concavity = findConcavity(right_contours_diff_2, [*range(-30, -1+1), *range(2, 30+1)]) # Ignore 2nd difference of 0 or 1.
    left_concavity = findConcavity(left_contours_diff_2, [*range(-30, -1+1), *range(2, 30+1)]) # Ignore 2nd difference of 0 or 1.

    ####### UPPER 2/5 LOWER 3/5
    upper = sum(rowQuintile[:2])/2
    lower = sum(rowQuintile[2:])/3

    #####################################################################
    ########################### 4 ####################################### 955 / 1000, 95%
    if nHolesStrict == 0 or nHolesStrict == 1 and holeAreaStrict[0] == 1:
        if upperBarSandwich():
            if not segment[4]:
                return 4
    
    if rowSixth[0] <= 23:
        if rowSixth[5] <= 24:
            if rSixthSolid[2] >= 39:
                if segment[5]:
                    return 4

    #####################################################################
    ########################### 1 ####################################### 933 / 993, 95%
    if not segment[4] and not segment[5]:
        if nHolesStrict == 0:
            if max_left_diff in [*range(-2, 2+1)]:
                if max_right_diff in [-2, -1, 1, 2]:
                    return 1
                if range_row_solid_5 <= 27:
                    return 1
        if range_row_solid_5 <= 12:
            return 1

    if [round(x, 5) for x in rAvgSolid] == [round(x, 5) for x in rAvgBool]:
        if max_row_solid_5 - min_row_solid_5 <= 17:
            return 1
    
    if nHolesStrict == 0:
        remainCount, shrededImg = destroyLayers(copy2D(img), 3)
        if remainCount == 0:
            if not segment[-1] and not segment[-3] and segment[1]:
                return 1
    
    ##################################################################### strict holes: 0->227, 1->736, 2->29, 3->3
    ########################### 6 ####################################### 855 / 980, 95%
    if not leftPinch(leftContour):
        if nHolesStrict <= 1:
            if max_left_diff_2 in [*range(-2, 4+1)]:
                if max_right_diff_2 in [*range(-6, 3+1)]:
                    if rSixthSolid[2] <= 48:
                        if segment[2]:
                            return 6
                    if not quadrant24(leftContour, rightContour):
                        return 0
                if rSixthSolid[2] <= 48:
                    if max_right_diff_2 in [*range(4, 16+1)]:
                        # printDigit()
                        return 6
                    if abs(max_right_diff) >= 6:
                        return 6
        elif nHolesStrict == 2:
            if max_left_diff in [-2, -1, 2, 3]:
                if max_right_diff in [*range(5, 13+1)]:
                    return 6
    if rQuintileSolid[0] <= 33:
        if rQuintileSolid[3] >= 70:
            if rSixthSolid[2] <= 48:
                if max_col_2 == colHalf[0]:
                    if nHolesStrict >= 1:
                        return 6
                return 2
            if rSixthSolid[1] <= 43:
                return 6
            # printDigit()
    
    if nHolesStrict <= 1:
        if rQuintileSolid[0] == min_row_solid_5 or rQuintileSolid[1] == min_row_solid_5:
            if rQuintileSolid[3] == max_row_solid_5:
                if abs(max_left_diff) <= 3:
                    if rSixthSolid[2] <= 48:
                        return 6
    if rSixthSolid[1] in [*range(16, 35+1)]:
        if rQuintileSolid[3] >= 87:
            return 6
    
    if max_top_diff >= 10:
        if segment[-1] and not segment[-3] and segment[0]:# and segment[2] and segment[3]:
            if len(left_concavity) == 1:
                return 6

    #####################################################################
    ########################### 9 ####################################### 856 / 1009, 85%
    if nHoles >= 1 and nHolesStrict <= 1: # 897 cases
        if abs(max_right_diff) >= 1 and abs(max_right_diff) <= 2 and abs(max_left_diff) >= 2 and max_left_diff_2 <= -3 and abs(max_bot_diff) != 2:
            if segment[6]:
                if segment[0]:
                    if not segment[2]:
                        return 9
    if nHoles == 1 and len(holeIndex) > 0 and max(holeIndex) <= height*2 //3 and max(holeArea) >= 10 and max_top_diff >= -3:
        return 9
    if rQuintileSolid[3] == min(rQuintileSolid) or rQuintileSolid[4] == min(rQuintileSolid):
        if rQuintileSolid[1] == max(rQuintileSolid):
            if max_top_diff in [*range(-16, -12+1), *range(-4, 4+1)]:
                if max_bot_diff <= 12:
                    if nHolesStrict <= 1:
                        if nHoles == 1:
                            if not segment[-1]:
                                return 9
                        if upperCrescent():
                            if quadrant24(leftContour, rightContour):
                                if segment[-2]:
                                    if not segment[-1]:
                                        return 9
                            if middleConnect():
                                return 9
                            return 7
                        elif max_top_diff in [*range(-3, 3+1)]:
                            return 7
    if rQuintileSolid[3] <= 37:
        if rQuintileSolid[1] >= 47:
            if rQuintileSolid[4] <= 37:
                if middleConnect():
                    if topLeftConnect():
                        return 9
    
    if nHolesStrict == 1:
        if rQuintileSolid[4] <= 37:
            if abs(rSixthSolid[5] - rSixthSolid[4]) <= 35:
                if middleConnect():
                    return 9

    if nHolesStrict < 2:
        if walkNumberNine(copy2D(img), leftContour):
            if not segment[-1]:
                return 9

    
    matches = matchCircle(arcE(4, 6))
    if matches[0][0] >= 90:
        if matches[0][1] < height*0.36:
            if [round(x, 5) for x in rAvgSolid][13:15+1] == [round(x, 5) for x in rAvgBool][13:15+1]:
                if not matchCircle((createCircle(2, 5)))[0][1] > height*2//3:
                    matches = matchCircle(arcW(4, 6))
                    if matches[0][0] >= 76 and matches[0][1] <= height//2:
                        if not segment[2]:
                            return 6
            
    #####################################################################
    ########################### 0 ####################################### 915 / 976, 93%
    if nHoles == 1:
        if holeLengths[0] >= 8 and max_right_diff < 6 and max_left_diff <= 3 and max_right_diff != 1 and max_bot_diff in range(-6, 4+1) and max_bot_diff != -1 and oneHoleSolidArea >= 60 and max_top_diff in range(-7, 7+1):
            return 0
        if max_top_diff in range(-7, 7+1) and zeroPositiveDiagonal(holeIdx):
            leftPinch(leftContour)
            if ma < height * 0.55:
                return 2
            if segment[-1]:
                return 0

    upperBarSandwich()
    if passStage1:
        if abs(rSixthSolid[1] - rSixthSolid[4]) <= 43:
            if abs(rSixthSolid[1] - rSixthSolid[4]) <= 32:
                if not leftPinch(leftContour):
                    if not quadrant24(leftContour, rightContour, tunnelHeight=7):
                        return 0
    
    if nHolesStrict == 1:
        if (darkCount + holeArea[0]) * 100 / (width * height) >= 70:
            if not quadrant24(leftContour, rightContour):
                return 0

    if not segment[-2] and segment[-1] and segment[2]:
        if rQuintileSolid[2] >= 70:
            return 0

    #####################################################################
    ########################### 7 ####################################### 804/ 864, 93%
    if max_bot_diff >= -4 and max_left_diff > 4:
        if abs(lineArea - solidArea) < 6 and max_row_5 == rowQuintile[0] and max_row_5 - min_row_5 > 30:
            if not segment[-1]:
                return 7
        if max_rows_5 == 1 and max_row_5 == rowQuintile[0] and upper > lower:
            if not segment[-1]:
                return 7
        if abs(max_top_diff) <= 2 and max_top_diff != 0:
            if not segment[-1]:
                return 7
    if rSixthSolid[5] <= 26:
        return 7
    
    if nHolesStrict == 0:
        if len(left_concavity) == 2 and len(right_concavity) == 1:
            return 7

    #####################################################################
    ########################### 8 ####################################### 872 / 979, 89%
    if max_left_diff in range(-5, 4+1) and max_left_diff != 1 and max_top_diff <= -6 and max_bot_diff not in range (-3, 5+1) and max_right_diff <= 4:
        if segment[0]:
            if segment[2]:
                return 8
    if twoHoleSolidArea >= 40 and nHoles == 2 and max_left_diff in range(-5, 4+1) and max_left_diff != 1 and max_right_diff <= 4:
        return 8
    if max_left_diff in range(-5, 4+1) and max_left_diff != 1 and max_bot_diff not in range (-2, 5+1) and middlePinch(leftContour, rightContour) and max_top_diff in [-1, *range(-16, -6+1)]:
        if segment[2]:
            return 8
    if max_left_diff in [*range(-8, -1+1), *(2, 4+1)]: # +20
        if rQuintileSolid[1] == max(rQuintileSolid):
            if rQuintileSolid[2] == min(rQuintileSolid):
                if segment[2]:
                    return 8
    if doubleLoop():
        if max_left_diff in [*range(-4, -1+1), *range(1, 8+1)]: # 19
            if max_bot_diff in [*range(-13, -3+1), *range(11, 14+1)]:
                if max_right_diff >= -3:
                    if segment[3]:
                        if segment[2]:
                            return 8
    if nHolesStrict == 2: # 638
        if quadrant24(leftContour, rightContour) >= 18:
            return 8
    if len(left_concavity) == 2 and len(right_concavity) == 3:
        if nHolesStrict >= 1:
            return 8

    #####################################################################
    ########################### 3 ####################################### 684 / 735, 93%
    if nHolesStrict == 0:
        if max_right_diff in range(-4, 5+1) and max_left_diff not in range(-4, 3+1) and max_left_diff_2 not in range(-3, 5+1):
            if doubleLoop():
                if matchCircle(arcE(2, 5, depth=5))[0][0] < 85:
                    if not segment[0] and not segment[2]:
                        return 3
        if abs(max_right_diff) == 2:
            if not segment[2]:
                return 3

    westArcMatches = matchArcW()
    upper = False
    lower = False
    for match in westArcMatches:
        if match[0] < 85:
            break
        if match[2] > width // 3:
            if match[1] > height//2:
                lower = True
            if match[1] < height //2:
                upper = True
    if upper and lower:
        return 3

    if nHolesStrict == 0:
        if segment == [0, 1, 0, 1, 1, 1, 1]:
            return 3

    if len(right_concavity) == 3:
        if right_concavity[-1] < right_concavity[0]:
            if right_concavity[1] <= 7:
                if quadrant24(leftContour, rightContour) >= 10:
                    matches = matchCircle(arcW(2, 4, depth=4))
                    pass1 = False
                    for match in matches:
                        if match[0] < 80:
                            break
                        if match[1] <= height//3 and match[2] in [*range(5, 9+1)]:
                            pass1 = True
                            break
                    if pass1:
                        matches = matchCircle(arcW(4, 6, depth=4))
                        if matches[0][1] > height//2:
                            if leftContour[height*3//4] > 0:
                                return 3

    #####################################################################
    ########################### 5 ####################################### 589 / 615, 95%
    if max_bot_diff in range(-16, 2+1) and max_bot_diff not in [-1, -4, -2, 1] and max_left_diff in range(-16, -2+1) and max_right_diff in range(-13, -2+1) and max_top_diff in range(-18, -1+1) and max_right_diff_2 not in range(-2, 3+1):
        return 5
    if nHolesStrict == 0:
        if max_right_diff in [*range(-15, -4+1), *range(6, 11+1)]:
            rightPinch(rightContour)
            if ma <= height//2:
                # return 5
                if not segment[1]: ####
                    return 5
                if quadrant24(leftContour, rightContour, tunnelHeight=3) >= 20:
                    return 5
            if not segment[0]:
                return 2

    if nHolesStrict == 0 and segment == [1, 0, 0, 1, 1, 1, 1]:
        return 5

    #####################################################################
    ########################### 2 ####################################### 637
    if max_bot_diff in range(-14, 17+1):
        return 2
    if nHoles == 0:
        if segment == [0, 1, 1, 0, 1, 1, 1] or segment == [0, 1, 1, 0, 1, 0, 1]:
            return 2

    return random.choice([*range(10)])


debug = 0
submit = 1
checkDigit = 9
n = int(input())
wrong = 0

for _ in range(n):
    inputImg = [list(map(float, input().split())) for _ in range(MAX)]
    darkest_point = max([max(i) for i in inputImg])
    inputImg = removeIslands(inputImg, 11)
    crop(1 * 15 / 100)

    img = [i[cMin:cMax+1] for i in inputImg[rMin:rMax+1]]

    rAvg = [sum(i)/width*100 for i in img]
    cAvg = [sum(i)/height*100 for i in zip(*img)]
    
    rAvgBool = [sum([j >= darkest_point * 15 / 100 for j in i])/width*100 for i in img]

    digit = findDigit()
    if submit:
        print(digit)
    # print("DIGIT IS", digit)
    if digit == checkDigit:
        # printDigit()
        wrong += 1
        if debug:
            if wrong > 20:
                # printInputDigit()
                printImage(img)
                break

if not submit:
    print(n)
    print(wrong)
