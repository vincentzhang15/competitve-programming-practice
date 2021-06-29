#include <bits/stdc++.h>
using namespace std;

bool horizontal(string s)
{
	if(s[0] == s[1] && s[1] == s[2] && s[1] != '.')
		return true;
	return false;
}

int vertical(string a, string b, string c)
{
	for(int i = 0; i < 3; i++)
	{
		if(a[i] == b[i] && b[i] == c[i] && b[i] != '.')
			return i;
	}
	return -1;
}

void calc()
{
	string a, b, c;
	cin >> a >> b >> c;
	
	if(horizontal(a))
	{
		cout << a[0] << endl;
		return;
	}
	else if(horizontal(b))
	{
		cout << b[0] << endl;
		return;
	}
	else if(horizontal(c))
	{
		cout << c[0] << endl;
		return;
	}
	
	int x = vertical(a, b, c);
	if(x != -1)
	{
		cout << b[x] << endl;
		return;
	}
	
	if(a[0] == b[1] && b[1] == c[2] && b[1] != '.')
	{
		cout << b[1] << endl;
		return;
	}
	if(a[2] == b[1] && b[1] == c[0] && b[1] != '.')
	{
		cout << b[1] << endl;
		return;
	}
	cout << "." << endl;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	for(int i = 0; i < 5; i++)
	{
		calc();
	}
	
	return 0;
}