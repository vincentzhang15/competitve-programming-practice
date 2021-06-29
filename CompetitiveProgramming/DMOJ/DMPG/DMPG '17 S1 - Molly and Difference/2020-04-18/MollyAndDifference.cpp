#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	vector<int> data;
	
	for(int i = 0; i < n; i++)
	{
		int in;
		cin >> in;
		data.push_back(in);
	}
	
	sort(data.begin(), data.begin()+n);
	
	int min = 999999999;
	for(int i = 0; i < n-1; i++)
	{
		if((data[i+1]-data[i] < min) && (data[i+1]-data[i] >= 0))
			min = data[i+1]-data[i];
	}
	cout << min << endl;
	
	return 0;
}