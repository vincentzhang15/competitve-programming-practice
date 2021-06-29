#include <iostream>
#include <math.h>
using namespace std;

int main()
{
	int h, m;
	cin >> h >> m;
	
	for(int t = 1; t <= m; t++)
	{
		int a = (-6*pow(t, 4)) + (h*pow(t, 3)) + (2*pow(t, 2)) + t;
		if(a <= 0)
		{
			cout << "The balloon first touches ground at hour:\n" << t << endl;
			return 0;
		}
	}
	cout << "The balloon does not touch ground in the given time." << endl;
}