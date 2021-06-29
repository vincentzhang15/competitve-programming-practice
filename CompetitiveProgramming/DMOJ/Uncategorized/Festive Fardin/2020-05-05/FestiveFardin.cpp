#include <bits/stdc++.h>
using namespace std;

bool works(string s)
{
	if(s.compare("red") == 0 || s.compare("green") == 0 || s.compare("white") == 0)
		return true;
	return false;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	string s1, s2;
	cin >> s1 >> s2;
	
	if(works(s1) && works(s2))
		cout << "Jingle Bells" << endl;
	else
		cout << "Boring..." << endl;
	
	return 0;
}