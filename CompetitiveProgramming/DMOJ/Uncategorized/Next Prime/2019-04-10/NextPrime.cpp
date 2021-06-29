#include <iostream>
#include <math.h>
using namespace std;

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
	cin >> n;
	
	while(!isPrime(n))
		n++;
	
	if(n == 1)
		cout << 2 << endl;
	else
		cout << n << endl;
	
	return 0;
}