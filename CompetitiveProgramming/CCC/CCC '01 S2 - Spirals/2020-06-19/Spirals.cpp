#include <bits/stdc++.h>
using namespace std;

int data [100][100];
int a, b;
int minx = 50;
int miny = 50;
int maxx = 50;
int maxy = 50;

void move(int x, int y, int i)
{
	if(i < b)
		data[x][y] = i;
	else
	{
		data[x][y] = i;
		for(int i = miny; i <= maxy; i++)
		{
			for(int j = minx; j <= maxx; j++)
			{
				if(data[i][j] == -1)
					cout << "   ";
				else
				{
					if(data[i][j] < 10)
					{
						if(j == maxx)
							cout << " " << data[i][j];
						else
							cout << " " << data[i][j] << " ";
					}
					else
					{
						if(j == maxx)
							cout << data[i][j];
						else
							cout << data[i][j] << " ";
					}
				}
			}
			cout << endl;
		}
		exit(0);
	}
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	cin >> a >> b;
	
	for(int i = 0; i < 100; i++)
		for(int j = 0; j < 100; j++)
			data[i][j] = -1;

	move(50, 50, a);
	
	int x = 50;
	int y = 50;
	
	int xp = 1;
	int yp = 1;
	
	bool isX = 0;
	bool isN = 0;

	for(;;)
	{
		if(!isX)
		{
			for(int j = 0; j < yp; j++)
			{
				a++;
				if(isN)
				{
					y--;
					if(y < miny)
						miny = y;
				}
				else
				{
					y++;
					if(y > maxy)
						maxy = y;
				}
				move(y, x, a);
			}
			isX = 1;
			yp++;
		}
		else
		{
			for(int j = 0; j < xp; j++)
			{
				a++;
				if(isN)
				{
					x--;
					if(x < minx)
						minx = x;
				}
				else
				{
					x++;
					if(x > maxx)
						maxx = x;
				}
				move(y, x, a);
			}
			isN = !isN;
			isX = 0;
			xp++;
		}
	}
	
	return 0;
}