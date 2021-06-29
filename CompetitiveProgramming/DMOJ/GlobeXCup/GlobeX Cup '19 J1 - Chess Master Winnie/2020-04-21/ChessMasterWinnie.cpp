#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, m, a, b, c;
	cin >> n >> m >> a >> b >> c;
	
	bool data [n];
	for(int i = 0; i < n; i++)
	{
		cin >> data[i];
	}
	
	for(int i = 0; i < c; i++)
	{
		int temp;
		cin >> temp;
		if(data[temp-1])
			m += a;
		else
			m -= b;
	}
	cout << m << endl;
	
	return 0;
}