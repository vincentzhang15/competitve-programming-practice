#include <iostream>
using namespace std;

int main()
{
	int sx, sy, ex, ey, e;
	cin >> sx >> sy >> ex >> ey >> e;
	e = e - (abs(ey-sy) + abs(ex-sx));
	
	if(e >= 0 && e % 2 == 0)
		cout << "Y" << endl;
	else
		cout << "N" << endl;
	
	return 0;
}