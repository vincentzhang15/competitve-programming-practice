#include <iostream>
using namespace std;

int main()
{
	int a, b ,c, x, y, z;
	cin >> a >> b >> c >> x >> y >> z;
	
	int one = a*3 + b*2 + c;
	int two = x*3 + y*2 + z;
	
	if(one > two)
		cout << "A" << endl;
	else if(two > one)
		cout << "B" << endl;
	else
		cout << "T" << endl;
	
	return 0;
}