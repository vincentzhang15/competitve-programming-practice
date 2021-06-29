#include <iostream>
using namespace std;

long long n;

int calc(long long a)
{
	if(a > n)
		return 0;
	return calc(a*10+2) + calc(a*10+3) + 1;
}

int main()
{
	cin >> n;
	cout << (calc(2) + calc(3)) << endl;;
	
	return 0;
}