#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		string a,b,c;
		cin >> a >> b >> c;
		if(!a.compare(b))
			cout << a << "\n";
		else if( !a.compare(c))
			cout << a << "\n";
		else if(!b.compare(c))
			cout << b << "\n";
		else
			cout << "???\n";
	}
	
	return 0;
}