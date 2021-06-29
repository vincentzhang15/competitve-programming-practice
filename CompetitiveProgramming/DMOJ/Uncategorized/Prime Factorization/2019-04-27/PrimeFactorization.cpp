#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

int main()
{
	vector<int> primes;
	int a;
	
	int n;
	scanf("%d", &n);
	int max = -1;
	int data [n];
	for(int i = 0; i < n; i++)
	{
		int b;
		scanf("%d", &b);
		data[i] = b;
		if(data[i] > max)
			max = data[i];
	}
	
	int S = max;
	bool notPrime [S+1];
	for(int i = 2; i < S; i++)
		if(!notPrime[i])
		{
			primes.push_back(i);
			for(int j = 2; j <= S/i; j++)
				notPrime[i*j] = true;
		}
	
	
	for(int i = 0; i < n; i++)
	{
		a = data[i];
		while(a != 1)
		{
			for(int j = 0; j < primes.size(); j++)
			{
				//System.out.println(primes.get(j) + ":" + primes.size() + ":" + j + ":" + a + ":" + (a % primes.get(j) == 0));
				if(a % primes.at(j) == 0)
				{
					printf("%d ", primes.at(j));
					a/=primes.at(j);
					break;
				}
			}
		}
		printf("\n");
	}
	
	return 0;
}
