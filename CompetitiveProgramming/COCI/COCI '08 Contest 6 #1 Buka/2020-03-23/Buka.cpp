#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	string a, b;
	char c;
	
	cin >> a >> c >> b;
	
	if(c == '+')
	{
		if(a.length() != b.length())
		{
			cout << 1;
			int minn = min(a.length(), b.length());
			int maxx = max(a.length(), b.length());
			
			for(int i = 0; i < maxx-minn-1; i++)
				cout << 0;
			cout << 1;
			for(int i = 0; i < minn-1; i++)
				cout << 0;
		}
		else
		{
			cout << 2;
			for(int i = 0; i < a.length()-1; i++)
				cout << 0;
		}
	}
	else
	{
		cout << 1;
		for(int i = 0; i < ((a.length()-1)+(b.length()-1)); i++)
			cout << 0;
	}
	cout << endl;
	
	return 0;
}