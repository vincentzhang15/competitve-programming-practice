#include <bits/stdc++.h>
using namespace std;

int main()
{
	string n;
	getline(cin, n);
	
	string s;
	while(getline(cin, s))
	{
		int start = -1;
		for(int i = 0; i < s.length(); i++)
		{
			if((s[i] >= 'A' && s[i] <= 'Z') || s[i] == '\u00c4' || s[i] == '\u00d6' || s[i] == '\u00dc' || s[i] == '\u00df')
			{
				start = i;
			}
			if((start != -1) && ((s[i] >= ' ' && s[i] <= '@') || (s[i] >= '[' && s[i] <= '`') || (s[i] >= '{' && s[i] <= '~') || (s[i] == '\n') || (s[i] == '\r') || (s[i] == '\t')))
			{
				cout << (s.substr(start, i-start)) << endl;
				start = -1;
			}
			else if((start != -1) && (i == s.length()-1))
				cout << (s.substr(start)) << endl;
		}
	}
	
	return 0;
}