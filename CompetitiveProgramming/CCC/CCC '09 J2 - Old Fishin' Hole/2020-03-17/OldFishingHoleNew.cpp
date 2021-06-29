#include <bits/stdc++.h>
using namespace std;

void print(int a, int b, int c)
{
	printf("%d Brown Trout, %d Northern Pike, %d Yellow Pickerel\n", a, b, c);
}

int main()
{
	int a, b, c, s;
	cin >> a >> b >> c >> s;
	
	int count = 0;
	
	for(int i = 0; i <= s; i++)
	{
		for(int j = 0; j <= s; j++)
		{
			for(int k = 0; k <= s; k++)
			{
				if(i == 0 && j == 0 && k == 0)
					continue;
				
				if(a*i + b*j + c*k <= s)
				{
					print(i, j, k);
					count++;
				}
			}
		}
	}
	
	printf("Number of ways to catch fish: %d\n", count);

	return 0;
}