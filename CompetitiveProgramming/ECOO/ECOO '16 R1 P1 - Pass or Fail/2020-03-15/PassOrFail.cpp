#include <bits/stdc++.h>
using namespace std;

int main()
{
	for(int i = 0; i < 10; i++)
	{
		int t, a, p, q, n;
		cin >> t >> a >> p >> q >> n;
		
		int count = 0;
		for(int j = 0; j < n; j++)
		{
			int m1, m2, m3, m4;
			cin >> m1 >> m2 >> m3 >> m4;
			double mark = (m1*t + m2*a + m3*p + m4*q)/100.0;
			
			if((int)mark >= 50)
				count++;
		}
		cout << count << endl;
	}
	
	return 0;
}