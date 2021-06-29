#include <iostream>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	
	int first, temp;
	scanf("%d%d", &first, &temp);

	int people = first;
	int min = first;
	int max = first;

	for(int i = 0; i < n-2; i++)
	{
		int a, b;
		scanf("%d%d", &a, &b);
		people -= b;
		min -= b;
		
		if(people < max)
			max = people;
		
		people += a;
	}
	
	if(min < 0)
		printf("%d\n", 0);
	else
		printf("%d\n", min);
	
	printf("%d\n", max);

	return 0;
}