#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int a = 1;
	int b = n;
	
	while(a <= b)
	{
		if(a == b)
			cout << a << endl;
		else
			cout << a << " " << b << " ";
		a++;
		b--;
	}
	
	return 0;
}