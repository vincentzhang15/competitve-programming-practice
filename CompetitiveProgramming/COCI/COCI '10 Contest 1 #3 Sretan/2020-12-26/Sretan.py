import sys
print("{0:b}".format(int(sys.stdin.read())+1).replace('0', '4').replace('1', '7')[1:])