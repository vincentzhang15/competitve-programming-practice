#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, a, b;
	cin >> n >> a >> b;
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		int h;
		cin >> h;
		
		if(h >= a && h <= b)
			count++;
	}
	cout << count << endl;
	
	return 0;
}