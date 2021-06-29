#include <iostream>
using namespace std;

int main()
{
	int a, b, c, p;
	scanf("%d%d%d%d", &a, &b, &c, &p);
	
	int temp = p;
	int count = 0;
	for(int i = 0; i <= temp; i++)
	{
		p = temp;
		if((p - a*i) >= 0)
			p -= a*i;
		for(int j = 0; j <= temp; j++)
		{
			if((p - b*j) >= 0)
				p -= b*j;
			for(int k = 0; k <= temp; k++)
			{
				cout << "p:" << p << ":" << (c*k) << ":" << ((p - c*k) >= 0) << endl;
				if((p - c*k) >= 0)
					p -= c*k;
				else
					continue;
				if(!(i == 0 && j == 0 && k == 0))
				{
					printf("%d%s%d%s%d%s", i, " Brown Trout, ", j, " Northern Pike, ", k, " Yellow Pickerel\n");
					count++;
				}
			}
		}
	}
	printf("%s%d\n", "Number of ways to catch fish: ", count);
	
	return 0;
}