#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		int m;
		cin >> m;
		if(m > 0)
			count++;
	}
	cout << count << endl;
	
	return 0;
}