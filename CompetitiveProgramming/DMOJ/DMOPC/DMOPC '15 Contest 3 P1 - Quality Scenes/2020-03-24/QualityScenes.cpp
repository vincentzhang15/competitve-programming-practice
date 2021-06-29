#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b, c, d;
	cin >> a >> b >> c >> d;
	
	if(a < d)
	{
		if(c < b)
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}
	else
	{
		if(a < d)
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}
	
	return 0;
}