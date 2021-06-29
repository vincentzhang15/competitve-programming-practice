#include <bits/stdc++.h>
using namespace std;

struct Coord
{
	int x;
	int y;
	Coord(int x, int y)
	{
		this->x = x;
		this->y = y;
	}
};

int main()
{
	int n, m; // rows, columns
	cin >> n >> m;
	
	int map [n+1][m+1];
	int dist [n+1][m+1];
	bool visited [n+1][m+1];
	
	Coord *start = new Coord(0, 0);
	Coord *end = new Coord(0, 0);
	
	for(int i = 0; i <= n; i++)
		for(int j = 0; j <= m; j++)
			dist[i][j] = INT_MAX;
	for(int i = 0; i <= n; i++)
		for(int j = 0; j <= m; j++)
			visited[i][j] = false;

	for(int i = 0; i <= n; i++)
		for(int j = 0; j <= m; j++)
			cin >> map[i][j];


	start->x = 1;
	start->y = 1;
	end->x = n;
	end->y = m;
	
	queue<Coord> q;
	visited[start->x][start->y] = true;
	dist[start->x][start->y] = 0;
	q.push(*start);
	while(!q.empty())
	{
		int r = q.front().x;
		int c = q.front().y;
		q.pop();
		
		int current = map[r][c];
		for(int i = 1; i <= sqrt(current); i++)
		{
			int x = i;
			int y = current/i;
			
			//cout << r << ":" << c << endl;
			//cout << x << ":" << y << endl;
			//cout << (x <= n) << (y <= m) << (!visited[x][y]) << (dist[x][y] > dist[r][c] + 1) << endl;
			//cout << endl;
			
			if(x <= n && y <= m && !visited[x][y] && dist[x][y] > dist[r][c] + 1)
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
		cout << "no" << endl;
	else
		cout << "yes" << endl;

	return 0;
}