#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int data[n][n];
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			cin >> data[i][j];
	
	int corners[4];
	corners[0] = data[0][0];
	corners[1] = data[0][n-1];
	corners[2] = data[n-1][n-1];
	corners[3] = data[n-1][0];
	
	int index = 0;
	for(int i = 1; i < 4; i++)
		if(corners[i] < corners[index])
		{
			index = i;
		}
		
	switch(index)
	{
		case 0:
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
					cout << data[i][j] << " ";
				cout << endl;
			}
			break;
		case 1:
			for(int j = n-1; j >= 0; j--)
			{
				for(int i = 0; i < n; i++)
					cout << data[i][j] << " ";
				cout << endl;
			}
			break;
		case 2:
			for(int i = n-1; i >= 0; i--)
			{
				for(int j = n-1; j >= 0; j--)
					cout << data[i][j] << " ";
				cout << endl;
			}
			break;
		case 3:
			for(int j = 0; j < n; j++)
			{
				for(int i = n-1; i >= 0; i--)
					cout << data[i][j] << " ";
				cout << endl;
			}
			break;
	}
	
	return 0;
}