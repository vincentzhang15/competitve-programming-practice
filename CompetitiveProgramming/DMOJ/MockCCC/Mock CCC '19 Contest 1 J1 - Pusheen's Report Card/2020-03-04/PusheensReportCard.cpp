#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b;
	scanf("%d%d", &a, &b);
	
	if(a > b)
		printf("CS452\n");
	else if (b > a)
		printf("PHIL145\n");
	
	return 0;
}