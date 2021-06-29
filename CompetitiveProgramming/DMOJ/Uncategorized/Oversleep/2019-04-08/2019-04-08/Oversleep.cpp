#include <iostream>
#include <climits>
#include <queue>
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
	int n, m;
	cin >> n >> m;
	
	char map [n][m];
	int dist [n][m];
	bool visited [n][m];
	
	Coord *start = new Coord(0, 0);
	Coord *end = new Coord(0, 0);
	
	for(int i = 0; i < n; i++)
		for(int j = 0; j < m; j++)
			dist[i][j] = INT_MAX;
	for(int i = 0; i < n; i++)
		for(int j = 0; j < m; j++)
			visited[i][j] = false;

	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			cin >> map[i][j];
			if(map[i][j] == 's')
			{
				start->x = i;
				start->y = j;
			}
			else if(map[i][j] == 'e')
			{
				end->x = i;
				end->y = j;
			}
		}
	}
	
	/////////// BFS /////////////
	queue<Coord> q;
	visited[start->x][start->y] = true;
	dist[start->x][start->y] = 0;
	q.push(*start);
	while(!q.empty())
	{
		int r = q.front().x;
		int c = q.front().y;
		q.pop();
		int d [][2] = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
		for(int i = 0; i < 4; i++)
		{
			int x = r + d[i][0];
			int y = c + d[i][1];
			if(x >= 0 && y >= 0 && x < n && y < m && map[x][y] != 'X' && !visited[x][y] && dist[x][y] > dist[r][c] + 1)
			{
				visited[x][y] = true;
				dist[x][y] = dist[r][c] + 1;
				q.push(*(new Coord(x, y)));
			}
		}
		if(visited[end->x][end->y])
			break;
	}
	/////////// BFS /////////////
	
	if(dist[end->x][end->y] == INT_MAX)
		cout << "-1" << endl;
	else
		cout << dist[end->x][end->y] - 1 << endl;
	
	/*

	////////////////////////////////////////////////////////////////////////////////////// PRINT
	cout << "------------------------------------------------" << endl;
	cout << "------------------------------------------------" << endl;
	cout << "Start: (" << start->x << "," << start->y << ")" << endl;
	cout << "End: (" << end->x << "," << end->y << ")" << endl;
	cout << "-------------------------------------------- MAP" << endl;
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			cout << map[i][j];
		}
		cout << endl;
	}
	cout << "------------------------------------------- DIST" << endl;
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			cout << dist[i][j] << " ";
		}
		cout << endl;
	}
	cout << "------------------------------------------ VISIT" << endl;
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			cout << visited[i][j] << " ";
		}
		cout << endl;
	}
	cout << "------------------------------------------------" << endl;
	cout << "------------------------------------------------" << endl;
	////////////////////////////////////////////////////////////////////////////////////// PRINT
	*/
	
	return 0;
}