#include <iostream>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
		{
			if(i <= n/2)
			{
				int spaces = 2*i-1;
				if(spaces > 0)
				{
					if(j >= (n/2-spaces/2) && j <= (n/2+spaces/2))
						printf(" ");
					else
						printf("*");
				}
				else
					printf("*");
			}
			else
			{
				int spaces = 2*(n-i-1)-1;
				if(spaces > 0)
				{
					if(j >= (n/2-spaces/2) && j <= (n/2+spaces/2))
						printf(" ");
					else
						printf("*");
				}
				else
					printf("*");
				
			}
		}
		printf("\n");
	}
	
	return 0;
}