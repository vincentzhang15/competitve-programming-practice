#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	long long t;
	char temp [100001];
	int cell [100001];
	scanf("%d%ld", &n, &t);
	scanf("%s", &temp);
	
	for(int i = 0; i < 100001; i++)
		cell[i] = temp[i] - '0';

	for(int i = 0; i < t; i++)
	{
		int first = cell[0];
		int last = cell[n-1];
		for(int j = 0; j < n; j++)
		{
			int cur = cell[j];
			if(j == n-1)
				cell[j] = last ^ first;
			else
				cell[j] = last ^ cell[j+1];
			last = cur;
		}
	}
	
	for(int i = 0; i < n; i++)
		cout << cell[i];
	cout << endl;
	
	return 0;
}