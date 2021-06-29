#include <iostream>
using namespace std;

int main()
{
	int a, b, c, d;
	cin >> a >> b >> c >> d;
	
	if(b == c && (a == 8 || a == 9) && (d == 8 || d == 9))
		cout << "ignore" << endl;
	else
		cout << "answer" << endl;
	
	return 0;
}