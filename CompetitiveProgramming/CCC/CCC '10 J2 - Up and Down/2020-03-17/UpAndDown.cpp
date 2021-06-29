#include <bits/stdc++.h>
using namespace std;

int calc(int x, int y, int s)
{
	int start = 0;
	while(s > 0)
	{
		for(int j = 0; j < x; j++)
		{
			start++;
			s--;
			if(s <= 0)
				break;
		}
		for(int j = 0; j < y; j++)
		{
			start--;
			s--;
			if(s <= 0)
				break;
		}
	}
	
	return start;
}

int main()
{
	int a, b, c, d, s;
	cin >> a >> b >> c >> d >> s;
	
	int N = calc(a, b, s);
	int B = calc(c, d, s);
	
	cout << ((N>B)?("Nikky"):((N==B)?("Tied"):("Byron"))) << endl;
	
	return 0;
}