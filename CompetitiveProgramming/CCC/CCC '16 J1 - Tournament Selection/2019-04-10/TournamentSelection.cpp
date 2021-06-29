#include <iostream>
#include <vector>
using namespace std;

int main()
{
	vector<char> games;
	for(int i = 0; i < 6; i++)
	{
		char c;
		cin >> c;
		games.push_back(c);
	}
	
	int w = 0;
	for(char c : games)
	{
		if(c == 'W')
			w++;
	}
	
	if(w >= 5)
		cout << 1 << endl;
	else if(w >= 3)
		cout << 2 << endl;
	else if(w >= 1)
		cout << 3 << endl;
	else
		cout << -1 << endl;
	
	return 0;
}