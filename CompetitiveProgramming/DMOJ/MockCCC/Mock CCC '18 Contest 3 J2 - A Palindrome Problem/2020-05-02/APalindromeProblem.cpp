#include <bits/stdc++.h>
using namespace std;

bool check(string s)
{
	for(int i = 0; i <= s.length()/2; i++)
		if(s[i] != s[s.length()-i-1])
			return false;
	return true;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	string s;
	cin >> s;
	
	if(s.length() <= 1)
	{
		cout << "NO" << endl;
		return 0;
	}
	
	for(int i = 0; i < s.length()-1; i++)
	{
		string a = s.substr(0, i+1);
		string b = s.substr(i+1, s.length()-1-i);
		
		if(check(a) && check(b))
		{
			cout << "YES" << endl;
			return 0;
		}
	}
	cout << "NO" << endl;
	
	return 0;
}