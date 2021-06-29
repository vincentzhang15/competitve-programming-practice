#include <iostream>
using namespace std;

int main()
{
	int m, n;
	cin >> m >> n;
	
	int count = 0;
	for(int i = 1; i <= m; i++)
	{
		for(int j = 1; j <= n; j++)
		{
			if(i + j == 10)
			{
				count ++;
			}
		}
	}
	
	if(count == 1)
		cout << "There is 1 way to get the sum 10." << endl;
	else
		cout << "There are " << count << " ways to get the sum 10." << endl;
	
	return 0;
}