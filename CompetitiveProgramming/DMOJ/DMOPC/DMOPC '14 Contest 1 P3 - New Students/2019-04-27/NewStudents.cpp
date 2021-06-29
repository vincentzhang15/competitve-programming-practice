#include <iostream>
using namespace std;

int main()
{
	int n;
	int sum = 0;
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
	{
		int a;
		scanf("%d", &a);
		sum += a;
	}
	
	int s;
	scanf("%d", &s);
	for(int i = 0; i < s; i++)
	{
		int a;
		scanf("%d", &a);
		
		n++;
		sum += a;
		
		printf("%lf\n", (double)sum/n);
	}
	
	return 0;
}