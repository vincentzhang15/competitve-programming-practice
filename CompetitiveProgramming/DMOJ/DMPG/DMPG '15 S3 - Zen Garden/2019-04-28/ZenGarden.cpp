#include <iostream>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	
	int f [n];
	int sum = 0;
	for(int i = 0; i < n; i++)
	{
		scanf("%d", &f[i]);
		sum += f[i];
	}

	int m;
	scanf("%d", &m);
	for(int i = 0; i < m; i++)
	{
		int a, d;
		scanf("%d%d", &a, &d);
		
		int smaller = f[a-1]<f[a]?f[a-1]:f[a];
		if(d > smaller)
			sum -= smaller;
		else
			sum -= d;
	}
	printf("%d", sum);
	
	return 0;
}