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
		int m;
		cin >> m;
		
		if(data.find(m) != data.end())
			data[m] += 1;
		else
			data.insert(pair<int, int>(m, 1));
	}
	
	int max = -1;
	for(auto it : data)
	{
		if(it.second > max)
			max = it.second;
	}

	for(auto it : data)
	{
		if(it.second == max)
			cout << it.first << " ";
	}
		
	return 0;
}