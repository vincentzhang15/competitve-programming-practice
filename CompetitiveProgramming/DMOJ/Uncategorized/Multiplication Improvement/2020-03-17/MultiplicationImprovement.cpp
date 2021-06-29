#include <bits/stdc++.h>
using namespace std;

int main()
{
	string s;
	cin >> s;
	
	vector<long long> data;
	
	string str = "";
	long long p = 1;
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == 'x')
		{
			p *= stoll(str);
			data.push_back(stoll(str));
			str = "";
		}
		else
			str += s[i];
	}
	p *= stoll(str);
	data.push_back(stoll(str));
	
	sort(data.begin(), data.end());
	
	for(int i = 0; i < data.size(); i++)
	{
		if(i != data.size()-1)
			cout << data[i] << "x";
		else
			cout << data[i] << endl;
	}
	
	cout << p << endl;

	return 0;
}