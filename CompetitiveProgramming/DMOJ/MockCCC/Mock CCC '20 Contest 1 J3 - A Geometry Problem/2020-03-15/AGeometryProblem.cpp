#include <bits/stdc++.h>
using namespace std;

int main()
{
	long long x, y;
	cin >> x >> y;
	
	cout << x*y/4;
	
	if((x*y) % 4 == 0)
		cout << ".00" << endl;
	else if((x*y) % 4 == 1)
		cout << ".25" << endl;
	else if((x*y) % 4 == 2)
		cout << ".50" << endl;
	else
		cout << ".75" << endl;
	
	return 0;
}