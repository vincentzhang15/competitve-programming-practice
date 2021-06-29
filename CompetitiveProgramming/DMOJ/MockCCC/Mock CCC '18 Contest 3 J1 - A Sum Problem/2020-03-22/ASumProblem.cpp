#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int sum = 0;
	for(int i = 0; i < n; i++)
	{
		int m;
		cin >> m;
		sum += m;
	}
	
	cout << sum << endl;
	
	return 0;
}