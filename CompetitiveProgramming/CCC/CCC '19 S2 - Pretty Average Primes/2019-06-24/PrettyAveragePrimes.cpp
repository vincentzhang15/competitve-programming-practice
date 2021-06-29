#include <iostream>
#include <math.h>
using namespace std;

bool isPrime(int n)
{
	for(int i = 2; i <= sqrt(n); i++)
		if(n%i == 0)
			return false;

	return true;
}

void sum(int prime)
{
	string str;
	for(int i = 2; i <= prime; i++)
	{
		int a = i;
		int b = 2*prime-i;
		
		if(isPrime(a) && isPrime(b))
		{
			cout << a << " " << b << endl;
			return;
		}
	}
}

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int prime;
		cin >> prime;
		sum(prime);
	}
	
	return 0;
}