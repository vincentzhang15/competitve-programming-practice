#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int a;
		char b;
		cin >> a >> b;
		
		for(int i = 0; i < a; i++)
			cout << b;
		cout << endl;
	}
	
	return 0;
}