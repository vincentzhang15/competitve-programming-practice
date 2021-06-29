#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		bool broke = false;
		
		int t;
		cin >> t;
		
		int nFactors = 0;
		int factors [10000];
		map<int, int> sum;
		map<int, int> diff;
		for(int j = 1; j <= (int)sqrt(t); j++)
		{
			if(t%j == 0)
			{
				factors[nFactors] = j;
				factors[nFactors+1] = t/j;
				nFactors += 2;
				
				sum.insert(pair<int, int>(j+t/j, 0));
				diff.insert(pair<int, int>(abs(j-t/j), 0));
			}
		}
		
		bool found = false;
		for(auto it : sum)
		{
			if(diff.find(it.first) != diff.end())
			{
				found = true;
				printf("%d is nasty\n", t);
				break;
			}
		}
		if(!found)
			printf("%d is not nasty\n", t);
	}
	
	return 0;
}