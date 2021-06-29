#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b;
	scanf("%d%d", &a, &b);
	
	while(a < 0)
		a += b;

	printf("%d", abs(a%b));
	
	return 0;
}