#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	map<string, int> data;
	
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		map<string, int>::iterator it = data.find(s);
		if(it == data.end())
			data[s] =1;
		else
			data[s]++;
	}
	
	int max1 = 0;
	int sum = 0;
	for(map<string, int>::iterator it = data.begin(); it!= data.end(); it++)
	{
		if(it->second > max1)
			max1 = it->second;
		sum += it->second;
	}
	
	int rest = sum-max1;
	
	cout << (min(max1, rest+1) + rest) << endl;
	
	return 0;
}