#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int value = -1;
	int data[n];
	for(int i = 0; i < n; i++)
		cin >> data[i];

	for(int i = 0; i < n; i++)
	{
		if(data[i] != 0 && i-1 >= 0 && data[i-1] == 0)
		{
			value = data[i];
			break;
		}
		if(data[i] == 0 && i == n-1)
		{
			if(i-1 < 0)
			{
				cout << "YES" << endl;
				return 0;
			}
			value = data[i-1];
		}
	}

	int last;
	int current;
	if(data[0] == 0)
		last = value;
	else
		last = data[0];
	
	for(int i = 1; i < n; i++)
	{
		if(data[i] == 0)
			current = value;
		else
			current = data[i];
		
		if(current < last)
		{
			//cout << current << ":" << last << ":" << value << endl;
			cout << "NO" << endl;
			return 0;
		}
		
		last = current;
	}
	cout << "YES" << endl;
	
	return 0;
}