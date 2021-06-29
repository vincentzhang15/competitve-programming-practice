#include <bits/stdc++.h>
using namespace std;

int gcd(int a, int b)
{
	if(a == 0)
		return b;
	
	return gcd(b%a, a);
}

int main()
{
	int n;
	cin >> n;
	
	int a;
	cin >> a;
	for(int i = 0; i < n-1; i++)
	{
		int m;
		cin >> m;
		
		int d = gcd(a, m);
		cout << (a/d) << "/" << (m/d) << endl;
	}
	
	return 0;
}