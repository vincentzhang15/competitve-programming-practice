#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int y, m, d;
		cin >> y >> m >> d;
		if(y < 1989)
			cout << "Yes" << endl;
		else if(y == 1989 && m < 2)
			cout << "Yes" << endl;
		else if(y == 1989 && m == 2 && d <= 27)
			cout << "Yes" << endl;
		else
			cout << "No" << endl;
	}
	
	return 0;
}