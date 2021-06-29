#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	int a = n/2;
	int b = n-a;
	a++;
	b++;
	
	cout << (a*b) << "\n";
	
	return 0;
}