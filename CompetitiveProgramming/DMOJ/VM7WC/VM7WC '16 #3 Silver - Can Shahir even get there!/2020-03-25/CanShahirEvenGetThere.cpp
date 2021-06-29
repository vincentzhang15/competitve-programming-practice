#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, m, a, b;
	cin >> n >> m >> a >> b;
	
	if(a == b)
	{
		cout << "GO SHAHIR!" << endl;
		return 0;
	}
	
	map<int, vector<int>> data;
	bool visited [n+1];
	memset(visited, false, n+1);
	
	for(int i = 0; i < m; i++)
	{
		int x, y;
		cin >> x >> y;
		
		if(data.find(x) != data.end())
			data[x].push_back(y);
		else
		{
			vector <int> v;
			v.push_back(y);
			data.insert(pair<int, vector<int>>(x, v));
		}

		if(data.find(y) != data.end())
			data[y].push_back(x);
		else
		{
			vector <int> v;
			v.push_back(x);
			data.insert(pair<int, vector<int>>(y, v));
		}
	}
	
	queue<int> q;
	q.push(a);
	visited[a] = true;
	
	while(!q.empty())
	{
		int aa = q.front();
		q.pop();
		
		if(data.find(aa) != data.end())
		{
			for(int i = 0; i < data[aa].size(); i++)
			{
				int next = data[aa][i];
				if(next == b)
				{
					cout << "GO SHAHIR!" << endl;
					return 0;
				}
				if(!visited[next])
				{
					q.push(next);
					visited[next] = true;
				}
			}
		}
	}
	cout << "NO SHAHIR!" << endl;
	
	return 0;
}