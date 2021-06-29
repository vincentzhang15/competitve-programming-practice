#include <bits/stdc++.h>

using namespace std;

long long c1 [1000001];
map <long long, long long> c2;

long long calc(long long weight)
{
	if(weight == 1)
		return 1;
	if(weight > 1000000)
	{
		if(c2.find(weight-1000000) != c2.end())
			return c2[weight-1000000];
	}
	else
	{
		if(c1[weight] != 0)
			return c1[weight];
	}
	
	long long count = 0;
	for(long long k = 2; k <= weight; k++)
	{
		long long subweight = weight/k;
		long long finalK = weight/subweight;
		count += (finalK-k+1) * calc(subweight);
		k = finalK;
		//cout << subweight << ":" << finalK << ":" << count << ":" << k << endl;
	}
	
	if(weight > 1000000)
	{
		c2[weight-1000000] = count;
	}
	else
	{
		c1[weight] = count;
	}
	
	return count;
}


int main()
{
	for(int i = 0; i < 1000001; i++)
		c1[i] = 0;
	
	long long n;
	cin >> n;
	cout << calc(n) << endl;
	return 0;
}