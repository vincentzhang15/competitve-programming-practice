#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	string s;
	cin >> s;
	
	int count = 0;
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == 'C')
		{
			count++;
			if(count == 3)
			{
				cout << "NO" << endl;
				return 0;
			}
		}
		else
			count = 0;
	}
	cout << "YES" << endl;
	
	return 0;
}