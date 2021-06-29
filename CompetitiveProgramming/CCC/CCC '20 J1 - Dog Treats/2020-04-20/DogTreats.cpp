#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	
	int n = a + 2*b + 3*c;
	if(n >= 10)
		cout << "happy" << endl;
	else
		cout << "sad" << endl;
	
	return 0;
}