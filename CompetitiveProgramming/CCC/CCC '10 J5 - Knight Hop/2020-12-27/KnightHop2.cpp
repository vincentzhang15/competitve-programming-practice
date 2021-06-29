#include <bits/stdc++.h>
using namespace std;

struct Coord
{
	int x, y;
	Coord(int x, int y)
	{
		this->x = x;
		this->y = y;
	}
};

int main()
{
	int sx, sy, ex, ey;
	cin >> sx >> sy >> ex >> ey;
	
	if(sx == ex && sy == ey)
	{
		cout << 0 << endl;
		return 0;
	}
	
	int dist [8][8];
	for(int i = 0; i < 8; i++)
		for(int j = 0; j < 8; j++)
			dist[i][j] = 99999;
	dist[sx-1][sy-1] = 0;
	Coord *start = new Coord(sx-1, sy-1);
	Coord *end = new Coord(ex-1, ey-1);
	queue<Coord> q;
	q.push(*start);
	//cout << "here" << endl;
	while(!q.empty())
	{
		int r = q.front().x;
		int c = q.front().y;
		q.pop();
		
		//cout << dist[sx-1][sy-1] << endl;
		
		//cout << r << ":" << c << "---------------------------------" << endl;
		int d [8][2] = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}};
		for(int i = 0; i < 8; i++)
		{
			int x = r + d[i][0];
			int y = c + d[i][1];
			//cout << x << ":" << y << ":" << dist[x][y] << ":" << dist[r][c] << endl;
			if(x >= 0 && x <= 7 && y >= 0 && y <= 7 && dist[x][y] > dist[r][c] + 1)
			{
				//cout << x << ":" << y << " ++++" << endl;
				dist[x][y] = dist[r][c] + 1;
				//cout << dist[x][y] << endl;
				q.push(*(new Coord(x, y)));
				//cout << "------------" << endl;
				if(dist[end->x][end->y] != 99999)
				{
					cout << dist[x][y] << endl;
					return 0;
				}
			}
		}
	}
	cout << -1 << endl;
	
	return 0;
}