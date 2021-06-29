#include <bits/stdc++.h>
using namespace std;

int main()
{
	int p, n, r;
	scanf("%d%d%d", &p, &n, &r);
	
	int sum = n;
	for(int i = 1;;i++)
	{
		sum += n*pow(r, i);
		if(sum > p)
		{
			printf("%d\n", i);
			return 0;
		}
	}
	
	return 0;
}