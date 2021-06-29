#include <iostream>
using namespace std;

int main()
{
	int m, d;
	cin >> m >> d;
	
	if(m <= 1 || (m == 2 && d < 18))
		cout << "Before" << endl;
	else if(m > 2 || (m == 2 && d > 18))
		cout << "After" << endl;
	else
		cout << "Special" << endl;
	
	return 0;
}