#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int count = 0;
	for(int c = 3; c < n; c++)
		for(int b = 2; b < c; b++)
			for(int a = 1; a < b; a++)
				count++;
	
	cout << count << endl;
	
	return 0;
}