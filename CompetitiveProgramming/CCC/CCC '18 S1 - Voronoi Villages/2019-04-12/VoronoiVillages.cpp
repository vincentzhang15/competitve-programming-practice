#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int data[n];
	for(int i = 0; i < n; i++)
		cin >> data[i];
	sort(data, data + n);
	
	
	double points[n-1];
	for(int i = 1; i < n; i++)
		points[i-1] = (data[i]+data[i-1])/2.0;
	
	double min = points[1] - points[0];
	for(int i = 2; i < n-1; i++)
	{
		if(points[i] - points[i-1] < min)
			min = points[i] - points[i-1];
	}
	
	printf("%.1f\n", min);

	return 0;
}