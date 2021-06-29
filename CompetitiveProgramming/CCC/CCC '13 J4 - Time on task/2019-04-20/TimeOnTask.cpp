#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int t, n;
	scanf("%d%d", &t, &n);
	
	int data [n];
	for(int i = 0; i < n; i++)
		scanf("%d", &data[i]);
	sort(data, data+sizeof data/sizeof data[0]);
	
	int sum = 0;
	int i;
	for(i = 0; i < n; i++)
	{
		if(sum + data[i] > t)
			break;
		sum += data[i];
	}
	printf("%d", i);
	
	return 0;
}