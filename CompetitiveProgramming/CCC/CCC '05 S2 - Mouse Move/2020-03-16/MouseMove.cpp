#include <bits/stdc++.h>
using namespace std;

int main()
{
	int c, r;
	cin >> c >> r;
	
	int col = 0, row = 0;
	while(true)
	{
		int x, y;
		cin >> x >> y;
		
		if(x == 0 && y == 0)
			return 0;
		
		col += x;
		row += y;

		if(col > c)
			col = c;
		if(col < 0)
			col = 0;
		if(row > r)
			row = r;
		if(row < 0)
			row = 0;

		cout << col << " " << row << endl;
	}
	
	return 0;
}