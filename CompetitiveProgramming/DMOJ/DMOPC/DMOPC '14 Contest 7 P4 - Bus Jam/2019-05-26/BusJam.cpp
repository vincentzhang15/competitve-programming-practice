#include <iostream>
using namespace std;

int main()
{
	int n, m, h;
	scanf("%d%d%d", &n, &m, &h);
	int data [n];
	
	for(int i = n-1; i >= 0; i--)
		scanf("%d", &data[i]);
	
	int count = 0;
	for(int i = 0; i < n-1; i++)
	{
		data[i] -= h;
		for(;;)
		{
			if(data[i] <= data[i+1])
				break;
			data[i+1] += m;
			count++;
		}
	}
	
	printf("%d", count);
	
	return 0;
}