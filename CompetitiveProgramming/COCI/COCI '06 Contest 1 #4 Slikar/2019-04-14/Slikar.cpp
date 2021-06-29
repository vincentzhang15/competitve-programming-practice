#include <iostream>
#include <queue>
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
	queue<Coord> q;
	queue<Coord> floodQ;
	
	int row, col;
	cin >> row >> col;
	
	int dist[row][col];
	char map [row][col];
	bool visited [row][col];
	int flood [row][col];
	int d [][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	Coord *start = new Coord(0, 0);
	Coord *end = new Coord(0, 0);
	
	for(int i = 0; i < row; i++)
		for(int j = 0; j < col; j++)
		{
			dist[i][j] = -1;
			flood[i][j] = -1;
			visited[i][j] = false;
			
			cin >> map[i][j];
			if(map[i][j] == 'S')
			{
				start->x = i;
				start->y = j;
			}
			else if(map[i][j] == 'D')
			{
				end->x = i;
				end->y = j;
			}
			else if(map[i][j] == '*')
				flood[i][j] = 0;
		}
		
	for(int i = 0; i < row; i++)
		for(int j = 0; j < col; j++)
		{
			if(map[i][j] == '*')
			{
				for(int k = 0; k < 4; k++)
				{
					int x = i + d[k][0];
					int y = j + d[k][1];
					if(x >= 0 && x < row && y >= 0 && y < col && map[x][y] != 'X' && map[x][y] != 'D')
					{
						flood[x][y] = 1;
						floodQ.push(*(new Coord(x, y)));
					}
				}
			}
		}
		
	while(!floodQ.empty())
	{
		int r = floodQ.front().x;
		int c = floodQ.front().y;
		floodQ.pop();
		for(int i =0; i < 4; i++)
		{
			int x = r + d[i][0];
			int y = c + d[i][1];
			if(x >= 0 && x < row && y >= 0 && y < col && map[x][y] != 'X' && map[x][y] != 'D' && (flood[x][y] > flood[r][c] + 1 || flood[x][y] == -1))
			{
				flood[x][y] = flood[r][c] + 1;
				floodQ.push(*(new Coord(x, y)));
			}
		}
	}
	
	visited[start->x][start->y] = true;
	dist[start->x][start->y] = 0;
	q.push(*start);
	while(!q.empty())
	{
		int r = q.front().x;
		int c = q.front().y;
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int x = r + d[i][0];
			int y = c + d[i][1];
			//cout << "(" << x << "," << y << ") " << dist[x][y] << ":" << flood[x][y] << endl;
			if(x >= 0 && y >= 0 && x < row && y < col && !visited[x][y] && map[x][y] != 'X' && map[x][y] != '*' && (dist[r][c]+1 < flood[x][y] || flood[x][y] == -1) && (dist[x][y] > dist[r][c] + 1 || dist[x][y] == -1))
			{
				//cout << "HERE" << endl;
				visited[x][y] = true;
				dist[x][y] = dist[r][c] + 1;
				q.push(*(new Coord(x, y)));
			}
			if(visited[end->x][end->y])
			{
				//cout << "ENTERED" << endl;
				break;
			}
		}
		//cout << endl;
	}
	/*
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
			cout << flood[i][j] << " ";
		cout << endl;
	}
	cout << endl;
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
			cout << dist[i][j] << " ";
		cout << endl;
	}
	*/
	
	if(dist[end->x][end->y] != -1)
		cout << dist[end->x][end->y] << endl;
	else
		cout << "KAKTUS" << endl;
	
	return 0;
}