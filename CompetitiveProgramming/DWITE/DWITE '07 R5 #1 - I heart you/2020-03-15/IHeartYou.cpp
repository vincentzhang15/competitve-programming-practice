#include <bits/stdc++.h>
using namespace std;

void print(int n)
{
	for(int i = 0; i < n; i++)
		cout << " ~.~ ";
	cout << endl;
	for(int i = 0; i < n; i++)
		cout << "`   `";
	cout << endl;
	for(int i = 0; i < n; i++)
		cout << " \\./ ";
	cout << endl;
}

int main()
{
	int a, b, c, d, e;
	cin >> a >> b >> c >> d >> e;
	
	print(a);
	print(b);
	print(c);
	print(d);
	print(e);
	
	return 0;
}