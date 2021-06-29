#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	unsigned long long val = 1LL << 32;
	int n; cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		unsigned long long m; cin >> m;
		unsigned long long result = 1;
		
		for(int j = 2; j <= m; j++)
		{
			result = result * j % val;
			if(result == 0)
				break;
		}
		cout << (result) << endl;
	}
	return 0;
}