#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	scanf("%d", &n);
	
	int maxx = -1;
	int maxy = -1;
	int minx = INT_MAX;
	int miny = INT_MAX;
	
	for(int i = 0; i < n; i++)
	{
		int x, y;
		scanf("%d,%d", &x, &y);
		if(x > maxx)
			maxx = x;
		if(x < minx)
			minx = x;
		if(y > maxy)
			maxy = y;
		if(y < miny)
			miny = y;
	}
	printf("%d,%d\n", minx-1, miny-1);
	printf("%d,%d\n", maxx+1, maxy+1);
	
	return 0;
}