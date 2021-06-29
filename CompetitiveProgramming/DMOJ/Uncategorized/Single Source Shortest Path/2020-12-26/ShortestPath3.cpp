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
	
	int dist [10001]; memset(dist, 0x3f3f3f3f, sizeof dist); dist[1] = 0;
	priority_queue<pair<int, int>> q; q.push({0, 1});
	
	while(!q.empty())
	{
		int curW = q.top().first, curPos = q.top().second; q.pop();
		if(curW > dist[curPos]) continue;
		for(auto u : data[curPos])
		{
			int nextPos = u.first, nextW = u.second;
			if(dist[nextPos] > dist[curPos] + nextW)
			{
				dist[nextPos] = dist[curPos] + nextW;
				q.push({-dist[nextPos], nextPos});
			}
		}
	}
	
	for(int i = 1; i <= n; i++)
		cout << ((dist[i] == 0x3f3f3f3f)?(-1):(dist[i])) << endl;
	
	return 0;
}