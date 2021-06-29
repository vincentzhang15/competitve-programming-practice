#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n, c;
	cin >> n >> c;
	
	for(int i = 0; i < n; i++)
	{
		string s;
		int m;
		
		cin >> s >> m;
		
		if(m > c)
			cout << s << " will advance\n";
		else
			cout << s << " will not advance\n";
	}
	
	return 0;
}