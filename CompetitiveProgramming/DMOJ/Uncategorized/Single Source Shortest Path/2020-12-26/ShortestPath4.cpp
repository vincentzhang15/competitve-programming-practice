#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0); cin.tie(0);
	int n, m; cin >> n >> m;
	
	vector<pair<int, int>> data [10001];
	for(int i = 0; i < m; i++)
	{
		int a, b, w; cin >> a >> b >> w;
		data[a].push_back({b, w});
		data[b].push_back({a, w});
	}
	
	int d [10001]; memset(d, 0x3f3f3f3f, sizeof d); d[1] = 0;
	priority_queue<pair<int, int>> q; q.push({0, 1});
	while(!q.empty())
	{
		int w = q.top().first, a = q.top().second; q.pop();
		if(d[a] < w) continue;
		for(auto u : data[a])
		{
			int aa = u.first, ww = u.second;
			if(d[aa] > d[a] + ww)
			{
				d[aa] = d[a] + ww;
				q.push({-d[aa], aa});
			}
		}
	}
	
	for(int i = 1; i <= n; i++) cout << ((d[i] == 0x3f3f3f3f)?(-1):(d[i])) << endl;
	
	return 0;
}