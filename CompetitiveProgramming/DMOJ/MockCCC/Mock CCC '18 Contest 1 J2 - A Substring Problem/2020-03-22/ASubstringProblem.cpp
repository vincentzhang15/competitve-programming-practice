#include <bits/stdc++.h>
using namespace std;

int main()
{
	string s;
	cin >> s;
	
	for(int i = 0; i < s.length()-1; i++)
	{
		if(s[i] == s[i+1])
		{
			cout << "Even" << endl;
			return 0;
		}
	}
	cout << "Odd" << endl;
	
	return 0;
}