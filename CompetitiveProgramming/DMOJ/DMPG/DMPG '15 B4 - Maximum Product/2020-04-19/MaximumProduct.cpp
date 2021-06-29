#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int neg = 0;
	int prod = 1;
	vector<int> data;
	int enter = 0;
	int zero = 0;
	for(int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		if(temp == 0)
			zero ++;
		if(temp != 0)
		{
			if(temp < 0)
			{
				neg++;
				data.push_back(temp);
			}
			prod *= temp;
			enter++;
		}
	}
	
	if(enter == 0)
	{
		cout << 0 << endl;
		return 0;
	}
	
	if(data.size() == 1 && enter == 1)
	{
		if(zero > 0)
			cout << 0 << endl;
		else
			cout << data[0] << endl;
		return 0;
	}
	
	if(prod < 0)
	{
		sort(data.begin(), data.begin()+n);
		cout << prod/data[data.size()-1] << endl;
	}
	else
		cout << prod << endl;
	
	return 0;
}