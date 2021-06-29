#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		int count = 0;
		for(int j = 0; j < s.length(); j++)
		{
			if(s[j] == '(')
				count++;
			if(s[j] == ')')
				count--;
			if(count < 0)
			{
				cout << "NO" << endl;
				break;
			}
		}
		
		if(count > 0)
			cout << "NO" << endl;
		else if(count == 0)
			cout << "YES" << endl;
	}
	
	return 0;
}