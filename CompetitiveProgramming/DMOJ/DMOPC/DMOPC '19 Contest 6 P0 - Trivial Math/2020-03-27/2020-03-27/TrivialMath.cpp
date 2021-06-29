#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	
	int maxx = max(max(a, b), c);
	int sum = a+b+c;
	
	if((sum - maxx) > maxx)
		cout << "yes" << endl;
	else
		cout << "no" << endl;
	
	return 0;
}