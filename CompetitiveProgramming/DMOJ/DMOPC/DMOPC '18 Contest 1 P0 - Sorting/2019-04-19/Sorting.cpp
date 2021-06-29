#include <iostream>
using namespace std;

int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	if(c >= b && b >= a)
		cout << "Good job!" << endl;
	else
		cout << "Try again!" << endl;
	
	return 0;
}