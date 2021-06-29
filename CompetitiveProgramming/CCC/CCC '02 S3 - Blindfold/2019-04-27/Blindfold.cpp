#include <iostream>
using namespace std;

int main()
{
	int r, c;
	scanf("%d%d", &r, &c);
	char map [r][c];
	for(int i = 0; i < r; i++)
		for(int j = 0; j < c; j++)
			scanf(" %c", &map[i][j]);
		
	int n;
	scanf("%d", &n);
	char move [n];	
	for(int i = 0; i < n; i++)
		scanf(" %c", &move[i]);
		
	for(int i = 0; i < r; i++)
	{
		for(int j = 0; j < c; j++)
		{
			if(map[i][j] != 'X')
			{
				int d[4] = {1, 2, 3, 4};
				int dMove[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
				for(int k = 0; k < 4; k++)
				{
					bool exit = false;
					int dir = d[k];
					int x = i;
					int y = j;
					//cout << x << ":" << y << endl;
					for(int a = 0; a < n; a++)
					{
						if(move[a] == 'L')
						{
							dir--;
							if(dir < 1)
								dir = 4;
						}
						else if(move[a] == 'R')
						{
							dir++;
							if(dir > 4)
								dir = 1;
						}
						else
						{
							x += dMove[dir-1][0];
							y += dMove[dir-1][1];
							//cout << i << ":" << j << "-------------" << endl;
							//cout << x << ":" << y << endl;
							if(x < 0 || y < 0 || x >= r || y >= c || map[x][y] == 'X')
							{
								exit = true;
								break;
							}
						}
					}
					if(!exit)
					{
						//cout << i << ":" << j << " here " << x << ":" << y << endl;
						map[x][y] = '*';
					}
				}
			}
		}
	}
	//cout << endl;
	
	for(int i = 0; i < r; i++)
	{
		for(int j = 0; j < c; j++)
			printf("%c", map[i][j]);
		printf("\n");
	}
	
	return 0;
}