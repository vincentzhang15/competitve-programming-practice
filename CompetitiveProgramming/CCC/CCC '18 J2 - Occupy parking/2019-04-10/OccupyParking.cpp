#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	char a[n];
	for(int i = 0; i < n; i++)
		cin >> a[i];
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		char b;
		cin >> b;
		
		if(b == 'C' && b == a[i])
			count++;
	}
	cout << count << endl;
	
	return 0;
}