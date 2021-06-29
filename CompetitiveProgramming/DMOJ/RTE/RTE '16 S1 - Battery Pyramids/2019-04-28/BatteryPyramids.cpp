#include <iostream>
using namespace std;

int main()
{
	int t;
	scanf("%d", &t);
	
	for(int i = 0; i < t; i++)
	{
		int a, b;
		scanf("%d%d", &a, &b);

		a -= b;
		int sum = 0;
		
		for(int i = 1;; i++)
		{
			if(sum + (i+1)*i/2 > a)
			{
				printf("%d\n", sum);
				break;
			}
			sum += (i+1)*i/2;
		}
	}
	
	return 0;
}