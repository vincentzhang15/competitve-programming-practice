#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b;
	string s;
	
	cin >> a >> s >> b;
	if(s.compare("Infront") == 0)
		cout << (a-b) << endl;
	else
		cout << (a+b) << endl;
	
	return 0;
}