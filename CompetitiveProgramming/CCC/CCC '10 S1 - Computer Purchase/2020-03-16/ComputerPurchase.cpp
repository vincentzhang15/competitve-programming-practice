#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	map<string, int> data;
	vector<int> values;
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		int a, b, c;
		cin >> a >> b >> c;
		
		//cout << s << ":" << a << ":" << b << ":" << c << endl << endl;
		data.insert(pair<string, int>(s, (a*2+b*3+c)));
		
		//cout << "MAP" << endl;
		//for(auto it : data)
		//	cout << it.first << ":" << it.second << endl;
		//cout << endl << endl;

		values.push_back((a*2+b*3+c));
	}
	sort(values.begin(), values.end());
	
	//for(int i : values)
	//	cout << i << endl;
	//cout << endl;
	//cout << values[values.size()-1] << ":" << values[values.size()-2] << endl;
	
	string first = "";
	for(map<string, int>::iterator it = data.begin(); it != data.end(); it++)
		if(it->second == values[values.size()-1])
		{
			cout << it->first << endl;
			first = it->first;
			break;
		}
	for(map<string, int>::iterator it = data.begin(); it != data.end(); it++)
		if(it->second == values[values.size()-2] && it->first != first)
		{
			cout << it->first << endl;
			break;
		}
	
	return 0;
}