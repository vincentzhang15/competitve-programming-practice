#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	
	int maxx = max(a, max(b, c));
	if((a+b+c-maxx) > maxx)
		cout << "yes" << endl;
	else
		cout << "no" << endl;
	
	return 0;
}