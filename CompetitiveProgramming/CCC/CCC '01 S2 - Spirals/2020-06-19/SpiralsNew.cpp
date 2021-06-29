#include <bits/stdc++.h>
using namespace std;

int data [100][100];
int a, b;
int minx;
int miny;
int maxx;
int maxy;
bool stop;

vector<string> lines;

void processLine()
{
	bool hasSingle = 0;
	for(string line : lines)
	{
		if(line[0] == ' ' && line[1] != ' ')
			hasSingle = 1;
	}
	
	if(hasSingle)
	{
		for(string line : lines)
		{
			cout << line.substr(1);
		}
	}
	else
		for(string line : lines)
		{
			cout << line;
		}
	
	lines.clear();
}


void move(int x, int y, int i)
{
	if(i < b)
		data[x][y] = i;
	else
	{
		data[x][y] = i;
		for(int i = miny; i <= maxy; i++)
		{
			int prev = -2;
			string line = "";
			for(int j = minx; j <= maxx; j++)
			{
				if(b < 10)
				{
					if(data[i][j] == -1)
					{
						if(prev == -2)
							line += "  ";
					}
					else
					{
						prev = data[i][j];
						if(data[i][j] < 10)
						{
							if(j == maxx || data[i][j+1] == -1)
								line += to_string(data[i][j]);
							else
								line += to_string(data[i][j]) + " ";
						}
						else
						{
							if(j == maxx || data[i][j+1] == -1)
								line += to_string(data[i][j]);
							else
								line += to_string(data[i][j]) + " ";
						}
					}
				}
				else
				{
					if(data[i][j] == -1)
					{
						if(prev == -2)
							line += "   ";
					}
					else
					{
						prev = data[i][j];
						if(data[i][j] < 10)
						{
							if(j == maxx || data[i][j+1] == -1)
								line += " " + to_string(data[i][j]);
							else
								line += " " + to_string(data[i][j]) + " ";
						}
						else
						{
							if(j == maxx || data[i][j+1] == -1)
								line += to_string(data[i][j]);
							else
								line += to_string(data[i][j]) + " ";
						}
					}
				}
			}
			line += "\n";
			lines.push_back(line);
		}
		processLine();
		stop = 1;
	}
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n; 
	cin >> n;
	
	for(int k = 0; k < n; k++)
	{
		cin >> a >> b;
		
		stop = 0;
		
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < 100; j++)
				data[i][j] = -1;
		
		minx = 50;
		miny = 50;
		maxx = 50;
		maxy = 50;

		move(50, 50, a);
		if(stop)
			continue;
		
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
					if(stop)
						break;
				}
				if(stop)
					break;
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
					if(stop)
						break;
				}
				if(stop)
					break;
				isN = !isN;
				isX = 0;
				xp++;
			}
		}
		if(k != n-1)
			cout << endl;
	}
	
	return 0;
}