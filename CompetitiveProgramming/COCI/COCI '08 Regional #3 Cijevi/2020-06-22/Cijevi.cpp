#include <bits/stdc++.h>
using namespace std;

int r, c;
char data [26][26];

bool left(int i, int j)
{
	return (j > 0 && (data[i][j-1] == '-' || data[i][j-1] == '+' || data[i][j-1] == '1' || data[i][j-1] == '2'));
}

bool right(int i, int j)
{
	return (j < c-1 && (data[i][j+1] == '-' || data[i][j+1] == '+' || data[i][j+1] == '3' || data[i][j+1] == '4'));
}

bool up(int i, int j)
{
	return (i > 0 && (data[i-1][j] == '|' || data[i-1][j] == '+' || data[i-1][j] == '1' || data[i-1][j] == '4'));
}

bool down(int i, int j)
{
	return (i < r-1 && (data[i+1][j] == '|' || data[i+1][j] == '+' || data[i+1][j] == '2' || data[i+1][j] == '3'));
}

int main()
{
	scanf("%d%d", &r, &c);
	for(int i = 0; i < r; i++)
		scanf("%s", data[i]);

	for(int i = 0; i < r; i++)
	{
		for(int j = 0; j < c; j++)
		{
			if(data[i][j] != '.')
				continue;
			
			if(left(i, j) && right(i, j) && up(i, j) && down(i, j))
				printf("%d %d +\n", (i+1), (j+1));
			else if(up(i, j) && down(i, j))
				printf("%d %d |\n", (i+1), (j+1));
			else if(left(i, j) && right(i, j))
				printf("%d %d -\n", (i+1), (j+1));
			else if(right(i, j) && down(i, j))
				printf("%d %d 1\n", (i+1), (j+1));
			else if(right(i, j) && up(i, j))
				printf("%d %d 2\n", (i+1), (j+1));
			else if(left(i, j) && up(i, j))
				printf("%d %d 3\n", (i+1), (j+1));
			else if(left(i, j) && down(i, j))
				printf("%d %d 4\n", (i+1), (j+1));
		}
	}
	
	return 0;
}