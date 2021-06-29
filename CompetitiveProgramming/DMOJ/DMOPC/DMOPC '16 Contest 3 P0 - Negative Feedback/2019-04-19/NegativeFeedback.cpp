#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	double a, b, c;
	cin >> a >> b >> c;
	cout << round(a*(1+b/c)*100.0)/100.0 << endl;
	
	return 0;
}