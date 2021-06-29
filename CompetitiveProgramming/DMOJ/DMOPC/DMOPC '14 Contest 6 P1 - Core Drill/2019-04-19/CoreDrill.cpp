#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int r, h;
	cin >> r >> h;
	double v = 3.1415926535897932*r*r*h/3;
	
	cout << round(v*100)/100.0 << endl;
	
	return 0;
}