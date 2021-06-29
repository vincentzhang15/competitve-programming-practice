#include <bits/stdc++.h>
using namespace std;
/*
set<string> data;
map<string, string> save;

void calc(string s, string a, string r)
{

	cout << r << endl;
	if (s.length() == 0)
	{
		data.insert(a);
		return;
	}
	
	for (int i = 0; i < s.length(); i++)
	{
		string rest = s.substr(0, i) + s.substr(i + 1);
		calc(rest, a + s[i], rest);
	}
}
*/
int main()
{
	string n, h;
	cin >> n >> h;
	
	/*
	calc(n, "", "");
	int count = 0;
	for(string s : data)
	{
		if(h.find(s, 0) != string::npos)
			count++;
	}
	*/
	
	int count = 0;
	do
	{
		if(h.find(n, 0) != string::npos)
			count++;
	}
	while(next_permutation(n.begin(), n.end()));
	
	cout << count;
}