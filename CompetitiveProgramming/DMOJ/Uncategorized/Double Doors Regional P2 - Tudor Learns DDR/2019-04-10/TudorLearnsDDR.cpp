#include <iostream>
using namespace std;

int main()
{
	char a, b, c;
	cin >> a >> b >> c;
	
	if(a != b && b != c && c != a && ((a == 'U' && c == 'D') || (a == 'D' && c == 'U') || (a == 'L' && c == 'R') || (a == 'R' && c == 'L')))
	{
		if(a == 'U' || a == 'D')
		{
			cout << "Candle" << endl;
			return 0;
		}
		else if(a == 'L' || a == 'R')
		{
			cout << "Crossover" << endl;
			return 0;
		}
	}
	cout << "Neither" << endl;
	
	return 0;
}