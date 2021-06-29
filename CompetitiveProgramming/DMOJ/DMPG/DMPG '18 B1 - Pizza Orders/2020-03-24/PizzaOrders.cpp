#include <bits/stdc++.h>
using namespace std;

int calc(int a)
{
	if(a%3 == 0)
		return (a/3);
	return (a/3+1);
}

int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	
	cout << (calc(a) + calc(b) + calc(c)) << endl;
	
	return 0;
}