#include <iostream>
#include <math.h>
using namespace std;

int main()
{
	int n, k;
	cin >> n >> k;
	
	int sum = n;
	for(int i = 1; i <= k; i++)
		sum += n*pow(10, i);
	
	cout << sum << endl;
	
	return 0;
}