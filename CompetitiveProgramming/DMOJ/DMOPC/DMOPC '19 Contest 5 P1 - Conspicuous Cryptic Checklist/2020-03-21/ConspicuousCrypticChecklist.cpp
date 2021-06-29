#include <bits/stdc++.h>
using namespace std;

int n;
string data [201];

bool findData(string s)
{
	for(int i = 0; i < n; i++)
		if(data[i].compare(s) == 0)
			return true;
	return false;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int m;
	cin >> n >> m;
	
	for(int i = 0; i < n; i++)
		cin >> data[i];
	
	int count = 0;
	for(int i = 0; i < m; i++)
	{
		int temp;
		cin >> temp;

		bool exit = false;
		int j = 0;
		for(j; j < temp; j++)
		{
			string str;
			cin >> str;
			if(!findData(str))
				exit = true;
		}
		if(!exit)
			count++;
	}
	
	cout << count << "\n";

	return 0;
}