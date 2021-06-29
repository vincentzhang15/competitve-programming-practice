#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int a, b;
	scanf("%d%d", &a, &b);
	
	int count = 0;
	int i = 1;
	double ans;
	for(i = cbrt(a); ans <= b; i++)
	{
		ans = i*i*i;
		if(ans >= a)
			if(sqrt(ans) == (double)((int)sqrt(ans)))
				count++;
	}
	printf("%d", count);
	
	return 0;
}