#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	string t, s;
	cin >> t >> s;
	
	for(int i = 0; i < s.length(); i++)
	{
		if(t.find(s) != t.npos)
		{
			cout << "yes" << endl;
			return 0;
		}
		s = s.substr(1) + s[0];
	}
	cout << "no" << endl;
	
	return 0;
}