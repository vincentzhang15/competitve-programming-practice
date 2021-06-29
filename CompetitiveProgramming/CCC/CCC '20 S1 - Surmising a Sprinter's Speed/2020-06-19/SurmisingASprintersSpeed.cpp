#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	map<int, int> data;
	for(int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		data.insert(pair<int, int>(a, b));
	}
	
	double max = -1;
	
	int lastx = 0;
	int lasty = 0;
	int i = 0;
	for(map<int, int>:: iterator it = data.begin(); it != data.end(); it++)
	{
		if(i == 0)
		{
			lastx = it->first;
			lasty = it->second;
		}
		else
		{
			int curx = it->first;
			int cury = it->second;
			
			double lmax = abs(cury-lasty)/(double)abs(curx-lastx);
			if(lmax > max)
				max = lmax;
			
			lastx = curx;
			lasty = cury;
		}
		i++;
	}
	cout << fixed << max << endl;
	
	return 0;
}