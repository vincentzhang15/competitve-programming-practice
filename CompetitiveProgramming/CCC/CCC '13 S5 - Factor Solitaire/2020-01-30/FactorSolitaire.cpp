#include <bits/stdc++.h>
using namespace std;

long long minCost = 1000000000000;

void findFactor(long long n, map<long long, long long> &factor)
{
	//cout << "n: " << n << endl;
	for(long long i = 1; i <= sqrt(n); i++)
	{
		if(n%i == 0)
		{
			factor[i] = n/i;
			factor[n/i] = i;
			//cout << i << ":" << (n/i) << endl;
		}
	}
}

void search(long long dest, long long last, long long cost)
{
	if(last > dest)
		return;
	if(last == dest)
	{
		if(minCost > cost)
			minCost = cost;
		return;
	}
	
	map<long long, long long> factor;
	findFactor(last, factor);
	
	//cout << "size: " << factor.size();
	//for(map<long long, long long>::reverse_iterator it = factor.rbegin(); it != factor.rend(); it++)
	//{
		//cout << it->first << ":" << it->second << endl;
	//}
	
	for(map<long long, long long>::reverse_iterator it = factor.rbegin(); it != factor.rend(); it++)
	{
		long long cur = last + it->first;
		long long nCost = cost + it->second;
		search(dest, cur, nCost);
	}
}

int main()
{
	long long n;
	cin >> n;
	search(n, 1, 0);
	cout << minCost;
	
	return 0;
}