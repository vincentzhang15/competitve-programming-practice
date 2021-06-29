#include <iostream>
using namespace std;

int main()
{
	int n, m;
	cin >> n >> m;
	int count = 0;
	
	for(int i = 0 ; i < m; i++)
	{
		int h;
		cin >> h;
		if(h >= n)
			count++;
	}
	
	cout << count << endl;
	
	return 0;
}