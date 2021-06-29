#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(int a)
{
	if(a == 2 || a == 3)
		return true;
	if(a % 2 == 0 || a % 3 == 0)
		return false;
	
	int divisor = 6;
	while (divisor * divisor - 2 * divisor + 1 <= a)
	{
		if (a % (divisor - 1) == 0)
		return false;

		if (a % (divisor + 1) == 0)
		return false;

		divisor += 6;
	}
	return true;
}
/*
int nextPrime(int a)
{
	while(!isPrime(a++))
	{}
	return a;
}
*/
int main()
{
	int n;
	scanf("%d", &n);
	
	for(int i = 0; i < n; i++)
	{
		int a;
		scanf("%d", &a);

		/*
		bool prime = true;
		{
			for(int k = 2; k <= sqrt(a); k++)
			{
				if(a%k == 0)
				{
					prime = false;
					break;
				}
			}
		}
		*/
		//if(prime)
		if(isPrime(a))
			printf("%d ", a);
		else
		{
			while(a != 1)
			{
				//for(int j = 2; j <= a; j = nextPrime(j+1))
				for(int j = 2; j <= a; j++)
				{
					/*
					prime = true;
					for(int k = 2; k <= sqrt(j); k++)
					{
						if(j%k == 0)
						{
							prime = false;
							break;
						}
					}
					*/
					//if(prime && a % j == 0)
					if(isPrime(j) && a % j == 0)
					{
						while(1)
						{
							if(a % j == 0)
							{
								a /= j;
								printf("%d ", j);
							}
							else
								break;
						}
						break;
					}
				}
			}
		}
		printf("\n");
	}
	
	return 0;
}