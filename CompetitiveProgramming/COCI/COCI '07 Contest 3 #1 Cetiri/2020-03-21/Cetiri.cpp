#include <bits/stdc++.h>
using namespace std;

int data [3];

bool check(int d, int minn)
{
	for(int i : data)
		if(minn+d == i)
			return true;
	return false;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int a, b, c;
	cin >> a >> b >> c;
	
	int d = min(abs(a-b), abs(b-c));
	int minn = min(min(a, b), c);
	
	data[0] = a;
	data[1] = b;
	data[2] = c;

	if(!check(d, minn))
		cout << (d + minn);
	else if(!check(d*2, minn))
		cout << (d*2 + minn);
	else if(!check(d*3, minn))
		cout << (d*3 + minn);
	else
		cout << (d*4 + minn);
	
	return 0;
}