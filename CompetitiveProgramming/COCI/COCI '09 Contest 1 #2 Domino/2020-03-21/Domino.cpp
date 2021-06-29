#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	int sum = 0;
	for(int i = 0; i <= n; i++)
	{
		for(int j = i; j <= n; j++)
		{
			sum += i+j;
		}
	}
	cout << sum;
	
	return 0;
}