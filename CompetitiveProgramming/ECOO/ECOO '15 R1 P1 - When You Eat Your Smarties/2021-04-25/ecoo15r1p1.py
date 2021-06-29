import math;

for i in range(10):
	data = [0]*8
	while 1:
		line = input()
		if(line == "end of box"):
			break;
		if(line == ("orange")):
			data[0] += 1;
		if(line==("blue")):
			data[1]+=1;
		if(line==("green")):
			data[2]+=1;
		if(line==("yellow")):
			data[3]+=1;
		if(line==("pink")):
			data[4]+=1;
		if(line==("violet")):
			data[5]+=1;
		if(line==("brown")):
			data[6]+=1;
		if(line==("red")):
			data[7]+=1;
	total = 0
	for i in range(0, 7):
		total += math.ceil(data[i]/7.0)*13.0
	total += data[7]*16.0
	print(int(total))