#include <bits/stdc++.h>
using namespace std;


int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n, k;
	cin >> n >> k;
	
	bool isPrime [n+1];
	memset(isPrime, true, n+1);
	isPrime[0] = false;
	isPrime[1] = false;
	
	int step = 0;
	for(int i = 2; i <= n; i++)
	{
		if(isPrime[i])
		{
			step++;
			if(step == k)
			{
				cout << i << endl;
				return 0;
			}
			for(int j = i; j <= n/i; j++)
			{
				if(isPrime[i*j])
					step++;
				isPrime[i*j] = false;

				if(step == k)
				{
					cout << (i*j) << endl;
					return 0;
				}
			}
		}
	}

	return 0;
}