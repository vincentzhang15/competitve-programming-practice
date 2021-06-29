#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	int a = 0;
	int b = 0;
	for(int i = 0; i < n; i++)
	{
		double d;
		cin >> d;
		
		if(fmod(d, 1.0) >= 0.5)
			a++;
		else
			b++;
	}
	cout << a << endl << b << endl;
	
	return 0;
}