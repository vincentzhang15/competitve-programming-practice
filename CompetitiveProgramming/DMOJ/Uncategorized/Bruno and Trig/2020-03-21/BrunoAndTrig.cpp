#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int a, b, c;
	cin >> a >> b >> c;
	
	int maxx = max(max(a,b),c);
	if((a+b+c-maxx)<=maxx)
		cout << "Maybe I should go out to sea...\n";
	else
		cout << "Huh? A triangle?\n";
	
	return 0;
}