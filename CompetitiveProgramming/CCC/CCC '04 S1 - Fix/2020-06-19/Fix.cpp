#include <bits/stdc++.h>
using namespace std;

bool check(string s1, string s2)
{
	if(s1.length() == s2.length())
		if(s1.compare(s2) == 0)
			return true;
		
	if(s1.length() > s2.length())
	{
		string s = s2;
		s2 = s1;
		s1 = s;
	}
	
	if(s1.compare(s2.substr(0, s1.length())) == 0 || s1.compare(s2.substr(s2.length() - s1.length())) == 0)
		return true;
	return false;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		string s1, s2, s3;
		cin >> s1 >> s2 >> s3;
		
		if(check(s1, s2) || check(s1, s3) || check(s2, s3))
			cout << "No" << endl;
		else
			cout << "Yes" << endl;
	}
	
	return 0;
}