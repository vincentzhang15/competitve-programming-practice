#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		
		int min = a-c;
		int max = a-b;
		
		if(d >= min && d <= max)
			cout << "Yes" << endl;
		else
			cout << "No" << endl;
	}
	
	return 0;
}