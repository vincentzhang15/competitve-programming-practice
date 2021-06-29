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
	int n, h;
	cin >> n >> h;
	
	int dist [n][n];
	bool visited [n][n];
	int map [n][n];
	
	Coord *start = new Coord(0, 0);
	Coord *end = new Coord(0, 0);
	
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			cin >> map[i][j];
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			dist[i][j] = INT_MAX;
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			visited[i][j] = false;
		
	start->x = 0;
	start->y = 0;
	end->x = n-1;
	end->y = n-1;
	
	
	queue<Coord> q;
	visited[start->x][start->y] = true;
	dist[start->x][start->y] = 0;
	q.push(*start);
	while(!q.empty())
	{
		int r = q.front().x;
		int c = q.front().y;
		q.pop();
		int d [][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		for(int i = 0; i < 4; i++)
		{
			int x = r + d[i][0];
			int y = c + d[i][1];
			if(x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && map[x][y] - map[r][c] <= h && map[x][y] - map[r][c] >= h*-1 && dist[x][y] > dist[r][c] + 1)
			{
				visited[x][y] = true;
				dist[x][y] = dist[r][c] + 1;
				q.push(*(new Coord(x, y)));
			}
		}
		if(visited[end->x][end->y])
			break;
	}
	
	if(dist[end->x][end->y] == INT_MAX)
		cout << "no";
	else
		cout << "yes";
	
	
	return 0;
}