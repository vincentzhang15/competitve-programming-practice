#include <bits/stdc++.h>
using namespace std;

void printTime(int time)
{
	if(time < 0)
		time += 1440;
	if(time > 1440)
		time -= 1440;
	
	int h = (time / 60); 
	int m = (time % 60);
	
	string outH = "";
	if(h == 0)
		outH = "";
	else
		outH = to_string(h);
	
	string outM = "";
	if(m < 10)
		outM = "0" + to_string(m);
	else
		outM = to_string(m);
	
	cout << outH << outM;
}

int main()
{
	int n;
	cin >> n;
	
	int m = n%100;
	int h = ((n-m)%10000)/100;
	int time = h*60+m;
	
	
	printTime(time); cout << " in Ottawa" << endl;
	printTime(time-180); cout << " in Victoria" << endl;
	printTime(time-120); cout << " in Edmonton" << endl;
	printTime(time-60); cout << " in Winnipeg" << endl;
	printTime(time); cout << " in Toronto" << endl;
	printTime(time+60); cout << " in Halifax" << endl;
	printTime(time+90); cout << " in St. John's" << endl;
	
	return 0;
}