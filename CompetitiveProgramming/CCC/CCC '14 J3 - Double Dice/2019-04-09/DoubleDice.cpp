#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int a = 100;
	int d = 100;
	for(int i = 0; i < n; i++)
	{
		int x, y;
		cin >> x >> y;
		if(x > y)
			d-=x;
		else if(y > x)
			a-=y;
	}
	
	cout << a << endl;
	cout << d << endl;
	
	return 0;
}