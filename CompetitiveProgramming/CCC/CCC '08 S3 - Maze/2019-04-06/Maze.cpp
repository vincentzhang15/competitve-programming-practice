#include <iostream>
#include <queue>
#include <climits>
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
	int n, h, w;
	cin >> n;
	
	for(int loop = 0; loop < n; loop++)
	{
		cin >> h >> w;
		bool visited [h][w];
		int dist [h][w];
		char map [h][w];

		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				cin >> map[i][j];
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				dist[i][j] = INT_MAX;
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				visited[i][j] = false;

		Coord *start = new Coord(0, 0);
		Coord *end = new Coord(0, 0);
		
		start->x=0;
		start->y=0;
		end->x=h-1;
		end->y=w-1;
			
		////////////////// BFS /////////////////////
		queue<Coord> q;
		q.push(*start);
		visited[start->x][start->y] = true;
		dist[start->x][start->y] = 0;
		while(!q.empty())
		{
			int r = q.front().x;
			int c = q.front().y;
			q.pop();
			int d [][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
			for(int i = 0; i < 4; i++)
			{
				int x = r + d[i][0];
				int y = c + d[i][1];
				
				//cout << x << ":" << y << " ------------------ " << (x >= 0) << ":" << (y >= 0) << ":" << (x < h) << ":" << (y < w) << ":" << (visited[x][y] == false) << ":" << (map[x][y] != '*') << ":" << (dist[x][y] > dist[r][c] + 1) << endl;
				if(x >= 0 && y >= 0 && x < h && y < w && visited[x][y] == false && map[x][y] != '*' && dist[x][y] > dist[r][c] + 1)
				{
					// cout << x << ":" << y << "+++++++++++" << endl;
					if(map[r][c] == '-' && (i == 0 || i == 2))
						continue;
					else if(map[r][c] == '|' && (i == 1 || i == 3))
						continue;
					else
					{
						dist[x][y] = dist[r][c] + 1;
						visited[x][y] = true;
						q.push(*(new Coord(x, y)));
					}
				}
			}
			if(dist[end->x][end->y] != INT_MAX)
				break;
		}
		////////////////// BFS /////////////////////
		
		if(dist[end->x][end->y] == INT_MAX)
			cout << "-1" << endl;
		else
			cout << dist[end->x][end->y]+1 << endl;
		
		
		/*		
		cout << endl << "-----------" << endl;
		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < w; j++)
				cout << dist[i][j];
			cout << endl;
		}
		cout << "-----------" << endl;
		*/
	}
	
	return 0;
}