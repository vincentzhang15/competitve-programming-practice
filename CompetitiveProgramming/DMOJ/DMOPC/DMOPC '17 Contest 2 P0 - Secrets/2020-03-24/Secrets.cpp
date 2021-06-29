#include <bits/stdc++.h>
using namespace std;

int main()
{
	int x1, y1, x2, y2, x3, y3, d;
	cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> d;
	
	double d1 = sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
	double d2 = sqrt((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2));
	
	if(d1 <= d || d2 <= d)
		cout << "Yes" << endl;
	else
		cout << "No" << endl;
	
	return 0;
}