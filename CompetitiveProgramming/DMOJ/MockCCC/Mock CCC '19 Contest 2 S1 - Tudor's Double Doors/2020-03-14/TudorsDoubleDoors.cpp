#include <bits/stdc++.h>
using namespace std;

int main()
{
	long long a, b;
	cin >> a >> b;
	
	long long c = a*b/2;
	
	cout << c << (((a*b)%2==0)?(".0"):(".5")) << endl;
	
	return 0;
}