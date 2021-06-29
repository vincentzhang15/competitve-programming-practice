#include <bits/stdc++.h>
using namespace std;

int main()
{
	for(int n = 0; n < 5; n++)
	{
		string s;
		getline(cin, s);
		s += " ";
		
		int letters = 0;
		int wordcount = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z'))
				letters++;
			else
			{
				if(letters > 3)
					wordcount++;
				letters = 0;
			}
		}
		cout << wordcount << endl;
	}
	
	return 0;
}