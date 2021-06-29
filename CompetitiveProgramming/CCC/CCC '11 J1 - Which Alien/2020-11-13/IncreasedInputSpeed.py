import sys
data = sys.stdin.read().split('\n')

antenna = int(data[0])
eyes = int(data[1])

if antenna >= 3 and eyes <= 4:
	print("TroyMartian")
if antenna <= 6 and eyes >= 2:
	print("VladSaturnian")
if antenna <= 2 and eyes <= 3:
	print("GraemeMercurian")