#include <iostream>
#include <cmath>
using namespace std;

int sumFactors(int n)
{
	int sum = 0;
	for(int i = 1; i < n; i++)
		if(n % i == 0)
			sum += i;
	return sum;
}

int sumCubeDigit(int n)
{
	string s = to_string(n);
	int sum = 0;
	for(int i = 0; i < s.length(); i++)
	{
		sum += pow(s[i]-'0', 3);
	}
	return sum;
}

int main()
{
	for(int i = 1000; i <= 9999; i++)
		if(sumFactors(i) == i)
			cout << i << " ";
	cout << endl;
	
	for(int i = 100; i <= 999; i++)
		if(sumCubeDigit(i) == i)
			cout << i << " ";
	cout << endl;
	
	return 0;
}