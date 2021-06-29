#include <bits/stdc++.h>
using namespace std;

map<int, int> data [1001]; // at node: connection to other node, distance
int nodes, days;

vector<int> min (int from, int to)
{
	vector<int> result;
	//cout << from << ":" << to << endl;
	int dist [1001];
	bool visited [1001];
	const int MAX = 2147483647;
	
	for(int i = 0; i < 1001; i++)
		dist[i] = MAX;
	for(int i = 0; i < 1001; i++)
		visited[i] = false;

	queue <int> q;
	q.push(from);
	visited[from] = true;
	dist[from] = 0;
	while(!q.empty())
	{
		int r = q.front();
		q.pop();
		for(int i = 1; i <= nodes; i++)
		{
			if(r == i)
			{
				for(map<int, int>::iterator it = data[i].begin(); it != data[i].end(); it++)
				{
					int x = it->first;
					if(visited[x] != true && dist[x] > dist[r] + it->second)
					{
						dist[x] = dist[r] + it->second;
						visited[x] = true;
						q.push(x);
					}
				
				}
			}
			if(dist[to] != MAX)
			{
				result.push_back(dist[to]);
				result.push_back(to);
				return result;
			}
		}
	}
	result.push_back(MAX);
	return result;
}

int main()
{
	scanf("%d%d", &nodes, &days);
	
	for(int i = 0; i < nodes-1; i++)
	{
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		
		data[a][b] = c;
		data[b][a] = c;
	}
	
	int location [100001][2];
	for(int i = 0; i < days; i++)
	{
		int a, b;
		scanf("%d%d", &a, &b);
		location[i][0] = a;
		location[i][1] = b;
	}
	
	/*
	for(int i = 1; i <= nodes; i++)
	{
		for(map<int, int>::iterator it = data[i].begin(); it != data[i].end(); it++)
		{
			cout << i << ":" << it->first << ":" << it->second << endl;
		}
	}
	*/
	
	/*
	for(int i = 0; i < days; i++)
	{
		cout << location[i][0] << ":" << location[i][1] << endl;
	}
	*/
	
	vector<int> value11 = min(1, location[0][0]);
	vector<int> value12 = min(location[0][0], location[0][1]);
	int sum1 = value11[0] + value12[0];
	int to1 [] = {value11[1], value12[1]};
	
	vector<int> value21 = min(1, location[0][1]);
	vector<int> value22 = min(location[0][1], location[0][0]);
	int sum2 = value21[0] + value22[0];
	int to2 [] = {value21[1], value22[1]};
	
	for(int i = 0; i < days-1; i++)
	{
		int a = min(valueReturned[1], location[i][0]);
		int b = min(location[i][0], location[i][1]);
		
		int c = min(1, location[i][1]);
		int d = min(location[i][1], location[i][0]);
		
		//cout << i << ":" << a << ":" << b << ":" << c << ":" << d << endl;
		
		sum += ((a+b)<(c+d))?(a+b):(c+d);
	}

	/*
	for(int i = 0; i < days; i++)
	{
		int a = min(1, location[i][0]);
		int b = min(location[i][0], location[i][1]);
		
		int c = min(1, location[i][1]);
		int d = min(location[i][1], location[i][0]);
		
		//cout << i << ":" << a << ":" << b << ":" << c << ":" << d << endl;
		
		sum += ((a+b)<(c+d))?(a+b):(c+d);
	}
	*/

	cout << sum << endl;
	
	return 0;
}