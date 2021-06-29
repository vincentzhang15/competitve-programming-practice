#include <bits/stdc++.h>
using namespace std;

string commands;
int data [12][12];

void generateCommands()
{
	commands = "";
	
	char dir [] = {'D', 'R', 'U', 'L'};
	int dIndex = 0;
	
	int repeat = 1;
	for(int i = 1; i <= 100; i++)
	{
		for(int j = 0; j < repeat; j++)
		{
			commands += dir[dIndex];
		}
		
		if(i%2 == 0)
			repeat++;
		dIndex = (dIndex+1)%4;
	}
}

void generateSpiral(int a, int b)
{
	for(int i = 0; i < 12; i++)
		for(int j = 0; j < 12; j++)
			data[i][j] = -1;
	
	int x = 5;
	int y = 5;
	data[x][y] = a;
	
	int index = 0;
	for(int i = a+1; i <= b; i++)
	{
		char c = commands[index];
		switch(c)
		{
			case 'D': x++; break;
			case 'R': y++; break;
			case 'U': x--; break;
			case 'L': y--; break;
		}
		data[x][y] = i;
		
		index++;
	}
}

void printSpiral()
{
	int row = 12;
	int col = 12;
	
	// CROP SPIRAL
	// Entire row -1 crop to -2
	for(int i = 0; i < 12; i++)
	{
		bool neg = true;
		for(int j = 0; j < 12; j++)
		{
			if(data[i][j] != -1)
			{
				neg = false;
				break;
			}
		}
		
		if(neg)
		{
			for(int j = 0; j < 12; j++)
				data[i][j] = -2;
			row--;
		}
	}

	// Entire col -1 crop to -3
	for(int i = 0; i < 12; i++)
	{
		bool neg = true;
		for(int j = 0; j < 12; j++)
		{
			if(data[j][i] != -1 && data[j][i] != -2)
			{
				neg = false;
				break;
			}
		}
		
		if(neg)
		{
			for(int j = 0; j < 12; j++)
				data[j][i] = -3;
			col--;
		}
	}
	
	
	string out [row][col];
	int r = 0;
	int c = 0;
	for(int i = 0; i < 12; i++)
	{
		if(data[i][(12-col)/2] != -2)
		{
			for(int j = 0; j < 12; j++)
			{
				if(data[i][j] != -3)
				{
					out[r][c] = to_string(data[i][j]);
					c++;
				}
			}
			c = 0;
			r++;
		}
	}
	
	for(int j = 0; j < col; j++)
	{
		int max = -1;
		for(int i = 0; i < row; i++)
		{
			if(out[i][j].compare("-1") != 0 && (int)out[i][j].length() > max)
				max = (int)out[i][j].length();
		}

		for(int i = 0; i < row; i++)
		{
			if(out[i][j].compare("-1") == 0)
			{
				if(max == 1)
					out[i][j] = " ";
				else
					out[i][j] = "  ";
			}
			
			if((int)out[i][j].length() < max)
				out[i][j] = " " + out[i][j];
		}
	}
	
	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
		{
			if(out[i][j].compare(" ") != 0 && out[i][j].compare("  ") != 0 && j != col-1 && out[i][j+1].compare(" ") != 0 && out[i][j+1].compare("  ") != 0)
				out[i][j] += " ";
		}
	}

	for(int i = 0; i < row; i++)
	{
		for(int j = 0; j < col; j++)
		{
			if(out[i][j].compare(" ") == 0 || out[i][j].compare("  ") == 0)
				cout << " " << out[i][j];
			else
				cout << out[i][j];
		}
		cout << endl;
	}
/*	
	for(int i = 0; i < row; i++)
	{
		bool hit = false;
		for(int j = 0; j < col; j++)
		{
			if(out[i][j].compare(" ") != 0 && out[i][j].compare("  ") != 0)
				hit = true;
			
			if(!hit)
			{
				cout << " " << out[i][j];
			}
			else
			{
				if((out[i][j].compare(" ") != 0 && out[i][j].compare("  ") != 0))
					cout << out[i][j];
			}
		}
		cout << endl;
	}
*/
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	generateCommands();
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		
		generateSpiral(a, b);
		printSpiral();
		if(i != n-1)
			cout << endl;
	}
	
	return 0;
}