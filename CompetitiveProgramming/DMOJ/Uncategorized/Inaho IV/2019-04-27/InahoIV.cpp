#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	
	double data [n];
	for(int i = 0; i < n; i++)
		scanf("%lf", &data[i]);
	
	double sum = 0;
	for(int i = 0; i < n; i++)
	{
		double a;
		scanf("%lf", &a);
		sum += (a-data[i]) * (a-data[i]);
	}
	printf("%lf", sqrt(sum));

	return 0;
}