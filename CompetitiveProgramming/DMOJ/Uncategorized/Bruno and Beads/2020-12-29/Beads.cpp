#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	string s;
	cin >> s;
	char c = s[0];
	int count = 1;
	for(int i = 0; i < n; i++)
	{
		if(s[i] != c)
		{
			c = s[i];
			count++;
		}
	}
	if(count > 3)
		cout << "FIX YOUR BEADS!" << endl;
	else
		cout << "Organized" << endl;
	
	return 0;
}