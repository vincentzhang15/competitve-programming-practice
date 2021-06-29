#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	for(int i = 0; i < 5; i++)
	{
		int d, m, y;
		cin >> d >> m >> y;

		if(y > 1997)
			cout << "too young" << endl;
		else if(y < 1997)
			cout << "old enough" << endl;
		else if(y == 1997)
		{
			if(m > 10)
				cout << "too young" << endl;
			else if(m < 10)
				cout << "old enough" << endl;
			else if(m == 10)
			{
				if(d > 27)
					cout << "too young" << endl;
				else if(d < 27)
					cout << "old enough" << endl;
				else if(d == 27)
					cout << "old enough" << endl;
			}
		}
	}
	
	return 0;
}