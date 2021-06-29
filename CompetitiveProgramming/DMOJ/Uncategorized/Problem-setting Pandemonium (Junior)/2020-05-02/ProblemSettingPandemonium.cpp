#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	set<int> data;
	for(int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		data.insert(temp);
	}
	cout << data.size() << endl;
	
	return 0;
}