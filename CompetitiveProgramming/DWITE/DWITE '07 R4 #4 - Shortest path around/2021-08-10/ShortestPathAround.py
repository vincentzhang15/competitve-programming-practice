"""
..........
..........
..........
....#.....
....#.....
X...#...X.
....#.....
....#.....
..........
..........
----------
..........
..........
........#.
........#.
X...#####X
...#......
..#.......
..........
..........
..........
----------
"""

def main():
    for _ in range(5):
        grid = []
        # Get grid.
        i = 0
        start = None
        end = None
        while 1:
            line = input()
            if line == "----------":
                break
            grid.append(list(line))

            while 1:
                idx = line.find('X')
                if idx == -1:
                    break
                if start == None:
                    start = (i, idx)
                else:
                    end = (i, idx)
                line = line[:idx] + '.' + line[idx+1:]
            i += 1
        
        r = len(grid)
        c = len(grid[0])
        dist = [[99999 for j in range(c)] for i in range(r)]
        dir = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]

        # BFS.
        queue = [start]
        dist[start[0]][start[1]] = 0
        while queue:
            exit = False
            top = queue.pop(0)
            x0 = top[0]
            y0 = top[1]

            for d in dir:
                x1 = x0 + d[0]
                y1 = y0 + d[1]

                if x1 >= 0 and y1 >= 0 and x1 < r and y1 < c and grid[x1][y1] != '#' and dist[x1][y1] > dist[x0][y0]+1:
                    dist[x1][y1] = dist[x0][y0] + 1
                
                    if x1 == end[0] and y1 == end[1]:
                        print(dist[x1][y1])
                        exit = True
                        break
                    queue.append((x1, y1))
            if exit:
                break
main()