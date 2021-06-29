#include <bits/stdc++.h>
using namespace std;

int main()
{
	bool data [33];
	memset(data, true, 33);
	data[0] = false;
	data[1] = false;
	
	for(int i = 2; i <= 32; i++)
	{
		if(data[i])
		{
			for(int j = 2; j <= 32/i; j++)
			{
				data[i*j] = false;
			}
		}
	}
	
	for(int i = 0; i < 5; i++)
	{
		int n;
		cin >> n;
		
		int count = 0;
		for(int j = 2; j < n; j++)
		{
			int temp = n;
			while(true)
			{
				if(data[j] && (temp%j == 0))
				{
					count ++;
					temp/=j;
				}
				else
					break;
			}
		}
		cout << count << endl;
	}
	
	return 0;
}