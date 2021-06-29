#include <bits/stdc++.h>
using namespace std;

int main()
{
	int x;
	int y[12];
	scanf("%d", &x);
	
	int sum = 0;
	for(int i = 0; i < x; i++)
	{
		scanf("%d", &y[i]);
		sum += y[i];
	}
	
	int even = sum/x;
	
	int count = 0;
	for(int i = 0; i < x; i++)
	{
		if(y[i] != even)
			count++;
	}
	
	cout << count << endl;

	return 0;
}