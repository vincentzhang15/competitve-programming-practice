#include <bits/stdc++.h>
using namespace std;

set<int> data;

long long calc(long long n, long long a, long long b, long long level)
{
	long long x = a*10+2;
	long long y = a*10+3;
	
	//cout << a << ":" << b << endl;
	//cout << x << ":" << y << endl;
	//cout << endl;
	
	if(x < n && y < n)
	{
		data.insert(x);
		data.insert(y);
		long long temp = calc(n, y, x, ++level);
		return calc(n, x, y, ++level);
	}
	else if(x < n)
	{
		data.insert(x);
		return calc(n, x, x, ++level);
	}
	else if(y < n)
	{
		data.insert(y);
		return calc(n, y, y, ++level);
	}
	else
		return 0;

	return 0;
}

int main()
{
	long long n;
	cin >> n;
	
	if(n == 2)
	{
		cout << 2 << endl;
		return 0;
	}
	if(n == 3)
	{
		cout << 3 << endl;
		return 0;
	}
	
	data.insert(2);
	data.insert(3);
	
	long long temp1 = calc(n, 2, 3, 1);
	long long temp2 = calc(n, 3, 2, 1);
	
	cout << data.size() << endl;
	
	//for(long long i : data)
	//	cout << i << endl;
	
	return 0;
}