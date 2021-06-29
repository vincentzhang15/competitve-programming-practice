#include <bits/stdc++.h>
using namespace std;

int main()
{
	for(int i = 0; i < 5; i++)
	{
		string s;
		cin >> s;
		bool didBreak = false;
		
		for(int j = 0; j < s.length(); j++)
		{
			char c = s[j];
			for(int k = 0; k < s.length(); k++)
			{
				if(k == j)
					continue;
				
				didBreak = false;
				if(s[k] == c)
				{
					didBreak = true;
					break;
				}
			}
			if(!didBreak)
			{
				cout << c << endl;
				break;
			}
		}
	}
	
	return 0;
}