#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	set<int> data;
	for(int i = 0; i < n; i++)
	{
		int x;
		cin >> x;
		data.insert(x);
	}
	
	for(int i : data)
		cout << i << endl;
	
	return 0;
}