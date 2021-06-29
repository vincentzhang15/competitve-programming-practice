#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	long long n, k;
	cin >> n >> k;
	
	long long a = n/(k+1);
	long long b = n%(k+1);
	
	cout << (a*k+b) << endl;
	
	return 0;
}