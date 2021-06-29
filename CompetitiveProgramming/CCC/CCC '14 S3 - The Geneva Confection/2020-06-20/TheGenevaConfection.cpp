#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	vector<int> data;
	for(int i = 0; i < n; i++)
	{
		int t;
		cin >> t;
		
		for(int j = 0; j < t; j++)
		{
			int s;
			cin >> s;
			data.push_back(s);
		}
		
		int count = 1;
		for(vector<int>::reverse_iterator it = data.rbegin(); it != data.rend(); it++)
		{
			if(*it == count)
			{
				data.erase(remove(data.begin(), data.end(), count), data.end());
				count++;
			}
		}
		
		for(int i : data)
			cout << i << endl;
		cout << endl;
		
		bool work = true;
		for(int i : data)
		{
			if(i < count)
			{
				cout << "N" << endl;
				work = false;
				break;
			}
			count = i;
		}
		if(work)
			cout << "Y" << endl;
		data.clear();
	}
	
	
	return 0;
}