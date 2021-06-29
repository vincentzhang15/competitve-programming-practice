#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <map>
using namespace std;

map <int, vector<string>> friends;

void addFriends(string a, string b)
{
	int x = stoi(a);
	int y = stoi(b);
	friends[x].push_back(b);
	friends[y].push_back(a);
}

void delFriends(string a, string b)
{
	int x = stoi(a);
	int y = stoi(b);
	int index1 = find(friends[x].begin(), friends[x].end(), b) - friends[x].begin();
	int index2 = find(friends[y].begin(), friends[y].end(), a) - friends[y].begin();
	friends[x].erase(friends[x].begin()+index1);
	friends[y].erase(friends[y].begin()+index2);
}

void friendsOfFriends (string a)
{
	int x = stoi(a);
	map <int, int> list;
	for(string a : friends[x])
	{
		int a1 = stoi(a);
		for(string b : friends[a1])
		{
			int b1 = stoi(b);
			bool has = 0;
			for(string c : friends[x])
			{
				int c1 = stoi(c);
				if(b1 == c1)
				{
					has = 1;
					break;
				}
			}
			if(b1 != x && !has)
			{
				list.insert(pair<int,int>(b1, 0));
			}
		}
	}
	cout << list.size() << endl;
}

void degSeparation(string a, string b)
{
	int x = stoi(a);
	int y = stoi(b);
	const int MAX = 2147483647;
	bool broke = 0;
	
	bool visited [friends.size()];
	int dist [friends.size()];
	for(int i = 0; i < friends.size(); i++)
		dist[i] = MAX;
	
	queue<int> q;
	q.push(x);
	dist[x] = 0;
	while(!q.empty())
	{
		int f1 = q.front();
		q.pop();
		for(int i = 0; i < friends[f1].size(); i++)
		{
			string f2temp = friends[f1][i];
			int f2 = stoi(f2temp);
			visited[f2] = true;
			
			if(dist[f2] > dist[f1] + 1)
			{
				dist[f2] = dist[f1] + 1;
				q.push(f2);
			}
		}
		if(dist[y] < 60 && dist[y] >= 0)
		{
			cout << dist[y] << endl;
			broke = 1;
			break;
		}
	}
	if(!broke)
		cout << "Not connected" << endl;
}

int main()
{
	addFriends("6", "1");
	addFriends("6", "2");
	addFriends("6", "3");
	addFriends("6", "4");
	addFriends("6", "5");
	addFriends("6", "7");
	addFriends("3", "4");
	addFriends("4", "5");
	addFriends("3", "5");
	addFriends("3", "15");
	addFriends("13", "15");
	addFriends("13", "12");
	addFriends("13", "14");
	addFriends("12", "11");
	addFriends("10", "11");
	addFriends("10", "9");
	addFriends("12", "9");
	addFriends("8", "9");
	addFriends("8", "7");
	addFriends("16", "17");
	addFriends("18", "17");
	addFriends("16", "18");
	
	while(1)
	{
		/*
		for(auto it = friends.begin(); it != friends.end(); ++it)
		{
			cout << it->first << " ";
			for(auto it2 = it->second.begin(); it2 != it->second.end(); ++it2)
				cout << *it2 << " ";
			cout << endl;
		}
		cout << "-----------------------------" << endl;
		*/
		
		char line;
		cin >> line;
		
		string a, b;
		switch(line)
		{
			case 'i':
				cin >> a >> b;
				addFriends(a, b);
				break;
			case 'd':
				cin >> a >> b;
				delFriends(a, b);
				break;
			case 'n':
				cin >> a;
				cout << friends[stoi(a)].size() << endl;
				break;
			case 'f':
				cin >> a;
				friendsOfFriends(a);
				break;
			case 's':
				cin >> a >> b;
				degSeparation(a, b);
				break;
			default: return 0;
		}
	}
	
	return 0;
}