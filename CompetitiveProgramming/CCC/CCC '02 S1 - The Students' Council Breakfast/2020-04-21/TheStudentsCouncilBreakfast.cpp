#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b, c, d, e;
	cin >> a >> b >> c >> d >> e;
	
	int combinations = 0;
	int minTickets = INT_MAX;
	for(int i = 0; i <= e; i++)
	{
		int ticketCount = 0;
		for(int j = 0; j <= e; j++)
		{
			for(int k = 0; k <= e; k++)
			{
				for(int l = 0; l <= e; l++)
				{
					if(a*i+b*j+c*k+d*l == e)
					{
						printf("# of PINK is %d # of GREEN is %d # of RED is %d # of ORANGE is %d\n", i, j, k, l);
						combinations++;
						ticketCount = i+j+k+l;
						if(ticketCount < minTickets)
							minTickets = ticketCount;
					}
				}
			}
		}
	}
	printf("Total combinations is %d.\n", combinations);
	printf("Minimum number of tickets to print is %d.\n", minTickets);
	
	return 0;
}