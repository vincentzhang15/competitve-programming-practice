#include <bits/stdc++.h>
using namespace std;

int hydrants(int &hose, int &h, int houses [])
{
	int k = 0; // hoses needed
	int startPos = 0;
	
	//cout << " hydrants: hose = " << hose << " "; for(int i=0; i<h;i++) cout << houses[i] << " "; cout << endl;
	
	for(int x = 0; x < h; x++)
	{
		if(k == 0 || (houses[x] - startPos) > hose * 2)
		{
			//printf(" k= %d x = %d houses = %d start = %d\n", k, x, houses[x], startPos);
			startPos = houses[x];
			k++;
		}
	}
	
	return k;
}

int main()
{
	int h, k;
	int houses [3000];
	
	cin >> h;
	for(int i = 0; i < h; i++)
		cin >> houses[i];
	cin >> k;
	
	sort(houses, houses+h);
	
	for(int i = 0; i < h; i++)
	{
		houses[h+i] = houses[i] + 1000000;
		houses[h+h+i] = houses[h+i] + 1000000;
	}
	
	int start = 0;
	int maxGap = 0;
	for(int i = 0; i < h; i++)
	{
		int gap = houses[i+1] - houses[i];
		if(maxGap < gap)
		{
			maxGap = gap;
			start = i+1;
		}
	}
	
	int lo = -1;
	int hi = 1000000;
	while(hi > lo+1)
	{
		int mid = (lo + hi)/2;
		if(hydrants(mid, h, houses+start) > k)
			lo = mid;
		else
			hi = mid;
	}
	
	cout << hi << endl;
	return 0;
}