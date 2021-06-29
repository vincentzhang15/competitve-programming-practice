#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	map <int, string> data;
	map <int, string> calls;
	
	for(int i = 0; i < n; i++)
	{
		string a;
		int b;
		cin >> a >> b;
		data.insert(pair<int, string>(b, a));
		calls.insert(pair<int, string>(b, "0"));
	}
	
	int m;
	cin >> m;
	
	int maxx = -1;
	int num = -1;
	for(int i = 0; i < m; i++)
	{
		//cout << "m" << m << ":" << i << endl;
		int a;
		cin >> a;
		int temp = stoi(calls[a]);
		temp++;
		calls[a] = to_string(temp);
		//cout  << ":" << data[a] << " ---" << a  << endl;
		
		
		if(temp > maxx)
		{
			maxx = temp;
			num = a;
		}
		else if(temp == maxx)
		{
			if(num > a)
			{
				maxx = temp;
				num = a;
			}
		}
	}
	cout << data[num] << endl;
	
	return 0;
}