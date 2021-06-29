#include <iostream>
#include <map>
using namespace std;

int main()
{
	map<int, int> one;
	map<int, int> two;
	
	int n;
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
	{
		int x, y, c;
		scanf("%d%d%d", &x, &y, &c);
		if(c == 1)
		{
			one[x] = y;
		}
		else
		{
			two[x] = y;
		}
	}
	
	for(int i = 0; i < one.size(); i++)
	{
		for(int j = 0; j < two.size(); j++)
		{
			for(int k = 0; k < one.size(); k++)
			{
				for(int a = 0; a < one.size(); a++)
				{
					isInside()
				}
				for(int b = 0; b < two.size(); b++)
				{
					
				}
			}
		}
	}
	
	return 0;
}