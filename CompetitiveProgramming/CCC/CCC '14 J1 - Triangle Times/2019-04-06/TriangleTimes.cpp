#include <iostream>
using namespace std;

int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	
	if(a == b && b == c && c == 60)
		cout << "Equilateral" << endl;
	else if(a + b + c == 180 && (a == b || b == c || c ==a))
		cout << "Isosceles" << endl;
	else if(a + b + c == 180 && a != b && b != c)
		cout << "Scalene" << endl;
	else
		cout << "Error" << endl;
	
	return 0;
}