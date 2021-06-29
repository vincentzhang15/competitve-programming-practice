#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	for(int i = 0; i < 5; i++)
	{
		map<string, vector<string>> data;
		map<string, bool> visited;
		int n;
		cin >> n;
		for(int j = 0; j < n; j++)
		{
			char c;
			string from, to;
			cin >> c >> from >> to;
			
			if(c == 'p')
			{
				visited.insert(pair<string, bool>(from, false));
				visited.insert(pair<string, bool>(to, false));
				
				if(data.find(from) == data.end())
				{
					vector<string> v;
					v.push_back(to);
					data.insert(pair<string, vector<string>>(from, v));
				}
				else
				{
					data[from].push_back(to);
				}
				
				if(data.find(to) == data.end())
				{
					vector<string> v;
					v.push_back(from);
					data.insert(pair<string, vector<string>>(to, v));
				}
				else
				{
					data[to].push_back(from);
				}
			}
			else
			{
				for(map<string, bool>::iterator it = visited.begin(); it != visited.end(); it++)
				{
					visited[it->first] = false;
				}
				
				queue<string> q;
				q.push(from);
				bool connected = false;
				
				while(!q.empty())
				{
					string s = q.front();
					q.pop();
					
					if(s == to)
					{
						connected = true;
						break;
					}
					
					if(visited.find(s) != visited.end() && !visited[s])
					{
						for(int k = 0; k < data[s].size(); k++)
						{
							if(data[s][k] != s && !visited[data[s][k]])
								q.push(data[s][k]);
						}
						visited[s] = true;
					}
				}
				//cout << from << ":" << to << ":";
				if(connected)
					cout << "connected" << endl;
				else
					cout << "not connected" << endl;
			}
		}
		
		/*
		for(map<string, vector<string>>::iterator it = data.begin(); it != data.end(); it++)
		{
			cout << it->first << endl;
			vector<string> v = it->second;
			for(string temp : v)
				cout << temp << endl;
			cout << endl;
		}
		cout << "-------------------" << endl;*/
	}
	
	
	return 0;
}