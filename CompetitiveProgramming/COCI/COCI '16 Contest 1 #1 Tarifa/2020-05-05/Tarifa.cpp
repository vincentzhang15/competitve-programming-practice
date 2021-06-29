#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int t, n;
	cin >> t >> n;
	
	int sum = (n+1)*t;
	for(int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		sum -= temp;
	}
	cout << sum << endl;
	
	return 0;
}