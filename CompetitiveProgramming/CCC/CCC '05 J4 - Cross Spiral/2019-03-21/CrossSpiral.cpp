#include <iostream>
using namespace std;

int main()
{
	int c, r, h, w, s;
	cin >> c >> r >> w >> h >> s;
	
	bool map [r][c];
	
	for(int i = 0; i < r; i++)
	{
		for(int j = 0; j < c; j++)
		{
			if(i < h && (j < w || j >= c-w))
				map[i][j] = 1;
			else if(i >= r-h && (j < w || j >= c-w))
				map[i][j] = 1;
			else
				map[i][j] = 0;
		}
	}

	int y = w;
	int x = 0;
	int dir = 1;
	//cout << "(" << x << "," << y << ")" << endl;
	for(int i = 1; i <= s; i++)
	{
		map[x][y] = 1;
		for(int j = 0; j < 4; j++)
		{
			int d = j + dir -1;
			if(d > 3) d -= 4;
			if(d < 0) d += 4;
				
			int x1 = x;
			int y1 = y;
			
			switch(d)
			{
				case 0: y1--; break;
				case 1: x1--; break;
				case 2: y1++; break;
				case 3: x1++; break;
			}
			//cout << j << ":" << "(" << x1 << "," << y1 << ")" << endl;
			if(x1 >= 0 && x1 < r && y1 >= 0 && y1 < c && map[x1][y1] == 0)
			{
				dir = d;
				x = x1;
				y = y1;
				break;
			}
		}
		/*cout << "---------------------------- " << i << endl;
		//cout << x << ":" << y << endl;
		
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				cout << map[i][j] << " ";
			}
			cout << endl;
		}*/
	}
	cout << y+1 << endl << x+1 << endl;
	
	return 0;
}