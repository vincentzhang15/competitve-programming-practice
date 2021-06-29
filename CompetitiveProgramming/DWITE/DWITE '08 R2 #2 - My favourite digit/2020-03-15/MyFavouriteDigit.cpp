#include <bits/stdc++.h>
using namespace std;

int main()
{
	for(int i = 0; i < 5; i++)
	{
		string s;
		cin >> s;
		
		int max = 0;
		for(int j = 0; j < s.length(); j++)
		{
			if(s[j] - '0' > max)
				max = s[j] - '0';
		}
		cout << max << endl;
	}
	
	return 0;
}