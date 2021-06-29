#include <iostream>
using namespace std;

int main()
{
	int unit, cheese;
	cin >> unit >> cheese;
	
	if(unit == 3 && cheese >= 95)
		cout << "C.C. is absolutely satisfied with her pizza." << endl;
	else if(unit == 1 && cheese <= 50)
		cout << "C.C. is fairly satisfied with her pizza." << endl;
	else
		cout << "C.C. is very satisfied with her pizza." << endl;
	
	return 0;
}