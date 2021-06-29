#include <bits/stdc++.h>
using namespace std;

int main()
{
	int N;
	cin >> N;
	
	for(int i = 0; i < N; i++)
	{
		long long n, a, b, t;
		cin >> n >> a >> b >> t;
		if(a*n < t)
		{
			cout << -1 << endl;
			continue;
		}
		
		long long mark = b*n+t;
		long long sum = b+a;
		cout << mark/sum+1 << endl;
	}
	
	return 0;
}