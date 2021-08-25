def main():
    line = __import__("sys").stdin.readline().rstrip()
    data = sorted([line.count(v) for v in set(line)])

    if len(data) <= 2:
        print(0)
        return
    print(len(line) - data[-1] - data[-2])
main()