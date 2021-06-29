#include <iostream>
#include <cstring>
using namespace std;

int main()
{
	bool isPrime [1000002];
	memset(isPrime, true, sizeof isPrime);
	isPrime[0] = false;
	isPrime[1] = false;
	for(int i = 2; i < 1000002; i++)
	{
		//cout << i << endl;
		if(isPrime[i])
		{
			for(int j = 2; j < 1000002/i; j++)
			{
				isPrime[i*j] = false;
			}
		}
	}
	
	for(int a = 0; a < 5; a++)
	{
		int sum = 0;
		int limit;
		scanf("%d", &limit);
		for(int i = 2; i <= limit; i++)
		{
			if(isPrime[i])
				sum += i;
		}
		printf("%d\n", sum);
	}
	
	return 0;
}