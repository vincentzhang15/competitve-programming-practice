#include <bits/stdc++.h>
using namespace std;

int maxSum()
{
	int a;
	int min = 999;
	int sum = 0;
	for(int i = 0; i < 5; i++)
	{
		scanf("%d", &a);
		sum += a;
		if(a < min)
			min = a;
	}
	
	return(sum-min);
}

int main()
{
	int a = maxSum();
	int b = maxSum();
	
	cout << ((a<b)?b:a) << endl;
	
	return 0;
}