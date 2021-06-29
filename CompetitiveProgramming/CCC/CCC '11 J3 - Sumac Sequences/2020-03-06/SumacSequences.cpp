#include <bits/stdc++.h>
using namespace std;

int main()
{
	int data [10000];
	scanf("%d%d", &data[0], &data[1]);
	
	for(int i = 0;; i++)
	{
		data[i+2] = data[i] - data[i+1];
		if(data[i+2] > data[i+1])
		{
			printf("%d", i+3);
			return 0;
		}
	}
	
	return 0;
}