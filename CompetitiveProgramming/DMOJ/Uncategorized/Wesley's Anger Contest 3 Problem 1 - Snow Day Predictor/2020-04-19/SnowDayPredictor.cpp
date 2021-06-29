#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t, d, p;
	cin >> t >> d >> p;
	
	int count = 0;
	if(t < -40)
		count++;
	if(d >= 15)
		count++;
	if(p > 50)
		count++;
	
	if(count >= 2)
		cout << "YES" << endl;
	else
		cout << "NO" << endl;
	
	return 0;
}