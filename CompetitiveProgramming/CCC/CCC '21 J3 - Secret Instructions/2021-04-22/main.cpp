#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	string dir = "";
	while(1)
	{
		string s; cin >> s;
		if(s == "99999")
			break;
		int sum = (int)s[0] - 48 + (int)s[1]-48;
		if(sum  ==0)
			cout << dir << " ";
		else if(sum %2==0)
			cout << (dir = "right") << " ";
		else
			cout << (dir = "left") << " ";
		cout << s.substr(2) << endl;
	}
	return 0;
}