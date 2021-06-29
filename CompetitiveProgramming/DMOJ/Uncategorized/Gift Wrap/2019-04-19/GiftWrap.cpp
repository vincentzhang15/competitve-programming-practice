#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int len = n*2-1;
	
	char map[len][len];
	for(int a = 0; a < n; a++)
	{
		char c = 'a' + (n-a-1);
		for(int i = a; i < len-a; i++)
			for(int j = a; j < len-a; j++)
				map[i][j] = c;
	}
	
	for(int i = 0; i < len; i++)
	{
		for(int j = 0; j < len; j++)
			cout << map[i][j];
		cout << endl;
	}
	
	return 0;
}