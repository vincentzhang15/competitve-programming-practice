#include <bits/stdc++.h>
using namespace std;

long long a, b;
bool p [20000000];
bool d [20000000];

int main()
{
	memset(p, 0, sizeof p);
	memset(d, 0, sizeof d);
	
	cin.sync_with_stdio(0);
	cin.tie(0);
	cin >> a >> b;
	
	for(int i = 2; i < 100000; i++)
		if(!p[i])
		{
			for(int j = i*2; j < 100000; j += i)
				p[j] = 1;
			for(long long j = (a+i-1)/i*i; j < b; j += i)
				if(j != i)
					d[j-a] = 1;
		}
	
	long long c = 0;
	for(int i = 0; i < b-a; i++)
		if(!d[i] && !(a == 1 && i == 0))
			c++;
	cout << c << endl;
	
	return 0;
}