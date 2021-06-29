#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int a, b;
	cin >> a >> b;
	
	for(;;)
	{
		int cur = a;
		int next = a/2;
		
		if(abs(cur-b) < abs(next-b))
		{
			cout << cur << endl;
			return 0;
		}
		a/=2;
	}
	
	return 0;
}