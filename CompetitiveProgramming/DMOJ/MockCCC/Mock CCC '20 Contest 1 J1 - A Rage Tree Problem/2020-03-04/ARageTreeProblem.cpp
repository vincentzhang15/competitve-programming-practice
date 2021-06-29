#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b, c ,d;
	scanf("%d%d%d%d", &a, &b, &c, &d);
	cout << min(min(min(a, b), c),d) << endl;
	cout << max(max(max(a, b), c),d) << endl;
	
	return 0;
}