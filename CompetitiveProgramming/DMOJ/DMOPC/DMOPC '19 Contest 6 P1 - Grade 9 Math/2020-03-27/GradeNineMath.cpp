#include <bits/stdc++.h>
using namespace std;

int main()
{
	int x1, y1, x2, y2;
	int x11, y11, x22, y22;
	cin >> x1 >> y1 >> x2 >> y2 >> x11 >> y11 >> x22 >> y22;
	
	if(x2-x1 == 0)
	{
		if(x22-x11 == 0 && x2 == x22)
		{
			cout << "coincident" << endl;
			return 0;
		}
		if(x22-x11 == 0)
		{
			cout << "parallel" << endl;
			return 0;
		}
		double m2 = (double)(y22-y11)/(x22-x11);
		double b2 = y22-m2*x22;
		double y = m2*x2+b2;
		
		cout << fixed << setprecision(8) << x2 << " " << y;
		return 0;
	}

	if(x22-x11 == 0)
	{
		if(x2-x1 == 0 && x2 == x22)
		{
			cout << "coincident" << endl;
			return 0;
		}
		if(x2-x1 == 0)
		{
			cout << "parallel" << endl;
			return 0;
		}
		double m1 = (double)(y2-y1)/(x2-x1);
		double b1 = y2-m1*x2;
		double y = m1*x22+b1;//
		
		cout << fixed << setprecision(8) << x22 << " " << y;
		return 0;
	}
	
	double m1 = (double)(y2-y1)/(x2-x1);
	double m2 = (double)(y22-y11)/(x22-x11);
	
	double b1 = y1-m1*x1;
	double b2 = y22-m2*x22;
	
	//cout << m1 << ":" << m2 << ":" << b1 << ":" << b2 << endl;
	if(m1 == m2 && b1 == b2)
		cout << "coincident" << endl;
	else if(m1 == m2)
		cout << "parallel" << endl;
	else
	{
		if(m1 == 0)
		{
			double x = (y1-b2)/m2;
			cout << fixed << setprecision(8) << x << " " << y1 << endl;
			//cout << m2 << endl;
			return 0;
		}
		if(m2 == 0)
		{
			double x = (y11-b1)/m1;
			printf("%.7f %.7f\n", ((y11-b1)/m1), y11);
			//cout << fixed << setprecision(8) << ((y11-b1)/(double)m1) << " " << y11 << endl;
			cout << b1 << endl;
			//cout << "HERE" << endl;
			return 0;
		}
		
		double y = (b2-(m2*b1/m1))/(1.0-(m2/m1));
		double x = (y-b1)/m1;
		
		cout << fixed << setprecision(8) << x << " " << y << endl;
	}
	
	
	return 0;
}