#include <iostream>
#include <math.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

bool isPrime(int n)
{
	for(int i = 2; i <= sqrt(n); i++)
		if(n % i == 0)
			return false;
	return true;
}

int main()
{
	int n;
	scan(n);
	
	while(!isPrime(n))
		n++;
	
	if(n == 1)
		printf("%d\n", 2);
	else
		printf("%d\n", n);
	
	return 0;
}