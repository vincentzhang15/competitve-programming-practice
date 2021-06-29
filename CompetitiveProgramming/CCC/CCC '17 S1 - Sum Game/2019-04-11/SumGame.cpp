#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int a = 0;
	int b = 0;

	int data1[n];
	int data2[n];
	for(int i = 0; i < n; i++)
	{
		cin >> data1[i];
		a += data1[i];
	}
	for(int i = 0; i < n; i++)
	{
		cin >> data2[i];
		b += data2[i];
	}
	
	for(int i = n-1; i >= 0; i--)
	{
		if(a == b)
		{
			cout << i+1 << endl;
			return 0;
		}
		a -= data1[i];
		b -= data2[i];
	}
	cout << 0 << endl;
	
	return 0;
}