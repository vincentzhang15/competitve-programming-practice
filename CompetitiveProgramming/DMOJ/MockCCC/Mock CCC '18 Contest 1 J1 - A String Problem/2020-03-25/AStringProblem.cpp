#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	n++;
	
	string s = to_string(n);
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == '0')
			cout << 1;
		else
			cout << s[i];
	}
	cout << endl;
	
	return 0;
}