#include <iostream>
using namespace std;

int main()
{
	int t, s, h;
	cin >> t >> s >> h;
	
	for(int i = 0; i < t; i++)
	{
		for(int k = 1; k < 3; k++)
		{
			cout << "*";
			for(int j = 0; j < s; j++)
			{
				cout << " ";
			}
		}
		cout << "*" << endl;
	}
	
	for(int i = 0; i < (s+1)*2+1; i++)
		cout << "*";
	cout << endl;
	
	for(int i = 0; i < h; i++)
	{
		for(int j = 0; j < s+1; j++)
			cout << " ";
		cout << "*" << endl;
	}
	
	return 0;
}