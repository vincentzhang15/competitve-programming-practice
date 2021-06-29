#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, m, q;
	scanf("%d %d %d", &n, &m, &q);

	map<int, vector<int>> lines;
	int a [n];
	
	for(int i = 0; i < n; i++)
	{
		int x;
		scanf("%d", &x);
		
		lines[x].push_back(i);
	}
	
	for(int i = 0; i < n; i++)
	{
		int x;
		scanf("%d", &x);
		
		a[i] = x;
	}
	
	for(int i = 0; i < q; i++)
	{
		int x;
		scanf("%d", &x);
		
		if(x == 1)
		{
			int l, r;
			scanf("%d %d", &l, &r);
			
			int people = 0;
			for(int j = l-1; j < r; j++)
			{
				people += a[j];
			}
			printf("%d\n", people);
		}
		else
		{
			int l;
			scanf("%d", &l);
			
			int temp = 0;
			int save = 0;
			for(int j = 0; j < lines[l].size(); j++)
			{
				temp = a[lines[l][j]];
				a[lines[l][j]] = save;
				save = temp;
			}
			a[lines[l][0]] = save;
		}
	}
	
	
	return 0;
}