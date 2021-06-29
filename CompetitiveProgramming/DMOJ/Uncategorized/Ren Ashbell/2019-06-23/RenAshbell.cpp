#include <iostream>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	
	int ren;
	for(int i = 0; i < n; i++)
	{
		if(i == 0)
			scanf("%d", &ren);
		else
		{
			int temp;
			scanf("%d", &temp);
			
			if(temp >= ren)
			{
				printf("NO");
				return 0;
			}
		}
	}
	printf("YES");
	
	return 0;
}