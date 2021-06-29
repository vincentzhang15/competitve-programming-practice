#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n, m;
	vector<pair<int, int>> data [10001];
	
	cin >> n >> m;
	for(int i = 0; i < m; i++)
	{
		int a, b, w;
		cin >> a >> b >> w;
		data[a].push_back({b, w});
		data[b].push_back({a, w});
	}
	
	priority_queue<pair<int, int>> q;
	int distance[10001];
	memset(distance, 0x3f3f3f3f, sizeof distance);
	distance[1] = 0;
	q.push({0, 1}); // w, to

	while(!q.empty())
	{
		int ww = q.top().first;
		int a = q.top().second; // to
		q.pop();
		
		if(ww > distance[a]) // w !> inf
			continue;
		
		for(auto u : data[a]) // to, bridges
		{
			int b = u.first, w = u.second;
			if (distance[a]+w < distance[b])
			{
				distance[b] = distance[a]+w;
				q.push({-distance[b],b});
			}
		}
	}
	for(int i = 1; i <= n; i++)
		if(distance[i] == 0x3f3f3f3f)
			cout << -1 << endl;
		else
			cout << distance[i] << endl;

	return 0;
}