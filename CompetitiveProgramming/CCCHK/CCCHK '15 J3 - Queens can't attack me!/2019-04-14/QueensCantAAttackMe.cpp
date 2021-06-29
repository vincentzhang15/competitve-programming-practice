#include <iostream>
using namespace std;

int main()
{
	int n, m;
	cin >> n >> m;
	int data [n][n];
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			data[i][j] = false;

	for(int i = 0; i < m; i++)
	{
		int x, y;
		cin >> x >> y;
		x--;
		y--;
		for(int j = x; j < n; j++)
			data[j][y] = true;
		for(int j = x; j >= 0; j--)
			data[j][y] = true;
		for(int j = y; j < n; j++)
			data[x][j] = true;
		for(int j = y; j >= 0; j--)
			data[x][j] = true;
		
		for(int j = 0; x+j < n && y+j < n; j++)
			data[x+j][y+j] = true;
		for(int j = 0; x+j < n && y-j >= 0; j++)
			data[x+j][y-j] = true;
		for(int j = 0; x-j >= 0 && y-j >= 0; j++)
			data[x-j][y-j] = true;
		for(int j = 0; x-j >= 0 && y+j < n; j++)
			data[x-j][y+j] = true;
		

	}
	
	int count = 0;
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			if(data[i][j] == false)
				count++;
	
	cout << count << endl;
	
	return 0;
}