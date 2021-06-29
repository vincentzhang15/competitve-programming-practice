#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int list [n];
	for(int i = 0; i < n; i++)
		cin >> list[i];
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		if(i == 0)
		{
			if(list[i] <= 41 && list[1] <= 41)
				count++;
		}
		else if(i == n-1)
		{
			if(list[i] <= 41 && list[n-2] <= 41)
				count++;
		}
		else
		{
			if(list[i] <= 41 && list[i-1] <= 41 && list [i+1] <= 41)
				count++;
		}
	}
	cout << count << endl;
	
	return 0;
}