#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	double prob = 1.0;
	for(int i = 0; i < n; i++)
	{
		double a, b;
		cin >> a >> b;
		
		//cout << ((b-a)) << ":" << b << ":" << ((b-a)/(double)b) << endl;
		prob *= (b-a)/(double)b;
	}
	cout << prob << endl;
	
	return 0;
}