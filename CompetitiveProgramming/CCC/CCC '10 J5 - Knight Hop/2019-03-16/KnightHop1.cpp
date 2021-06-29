#include <iostream>
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

int dist [8][8];
bool visited [8][8];
const int MAX = 2147483647;

void BFS(Coord *from, Coord *to)
{
	queue <Coord> q;
	q.push(*from);
	visited[from->x][from->y] = true;
	dist[from->x][from->y] = 0;
	while(!q.empty())
	{
		int r = q.front().x;
		int c = q.front().y;
		q.pop();
		int d [8][2] = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
		for(int i = 0; i < 8; i++)
		{
			int x = r + d[i][0];
			int y = c + d[i][1];
			if(x < 8 && x >= 0 && y < 8 && y >= 0 && visited[x][y] != true && dist[x][y] > dist[r][c] + 1)
			{
				dist[x][y] = dist[r][c] + 1;
				visited[x][y] = true;
				q.push(*(new Coord(x, y)));
			}
		}
		if(dist[to->x][to->y] != MAX)
			break;
	}
}

int main()
{
	int sx, sy, ex, ey;
	cin >> sx >> sy >> ex >> ey;
	
	Coord *start = new Coord(0, 0);
	Coord *end = new Coord(0, 0);
	
	for(int i = 0; i < 8; i++)
		for(int j = 0; j < 8; j++)
			dist[i][j] = MAX;
	
	start->x = sx-1;
	start->y = sy-1;
	end->x = ex-1;
	end->y = ey-1;
	
	BFS(start, end);
	cout << dist[end->x][end->y];
	//cout << start->x << ":" << start->y << endl;
	//cout << end->x << ":" << end->y << endl;
	
	return 0;
}