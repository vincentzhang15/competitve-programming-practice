#include <iostream>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	int data [n];
	
	for(int i = 0; i < n; i++)
		scanf("%d", &data[i]);
	for(int a : data)
		printf("%d ", a);
	printf("\n");
	
	for(int j = 1; j <= n; j++)
	{
		for(int i = 0; i < n-j; i++)
		{
			bool swap = false;
			if(data[i] > data[i+1])
			{
				int temp = data[i];
				data[i] = data[i+1];
				data[i+1] = temp;
				swap = true;
			}
			if(swap)
			{
				for(int a : data)
					printf("%d ", a);
				printf("\n");
			}
		}
	}
	
	return 0;
}