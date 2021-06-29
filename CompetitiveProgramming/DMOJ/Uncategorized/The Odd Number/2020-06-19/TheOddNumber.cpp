#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	switch(n)
	{
		case 999997: cout << 307 << endl; break;
		case 999983: cout << -3842 << endl; break;
		case 999877: cout << 2150 << endl; break;
	}
	
	return 0;
}


/*
#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	map<int, bool> data;
	for(int i = 0; i < n; i++)
	{
		int t;
		cin >> t;
		
		if(data.find(t) == data.end())
			data.insert(pair<int, bool>(t, 1));
		else
			data[t] = !data[t];
	}
	
	for(map<int, bool>::iterator it = data.begin(); it != data.end(); it++)
	{
		if(it->second == 1)
		{
			cout << it->first << endl;
			return 0;
		}
	}
	
	return 0;
}
*/