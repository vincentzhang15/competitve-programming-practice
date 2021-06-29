#include <bits/stdc++.h>
using namespace std;

int main()
{
	int max = -1;
	int who = -1;
	for(int i = 0; i < 5; i++)
	{
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		
		if(a+b+c+d > max)
		{
			max = a+b+c+d;
			who = i+1;
		}
	}
	
	cout << who << " " << max << endl;
	
	return 0;
}