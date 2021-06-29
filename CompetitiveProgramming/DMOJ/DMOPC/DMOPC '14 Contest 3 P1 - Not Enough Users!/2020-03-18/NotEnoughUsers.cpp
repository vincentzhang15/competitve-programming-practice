#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, k, d;
	cin >> n >> k >> d;
	
	cout << fixed << (int)round(n*round(pow(k, d))) << endl;
	
	return 0;
}