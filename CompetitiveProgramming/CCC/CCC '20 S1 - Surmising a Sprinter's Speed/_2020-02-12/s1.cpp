#include <bits/stdc++.h>
using namespace std;

int main()
{
	map<int, int> data;
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		
		data[a] = b;
	}
/*	for(map<int, int>::iterator it = data.begin(); it != data.end(); it++)
	{
		cout << it->first << ":" << it->second << endl;
	}
*/
	double max = 0;
	for(map<int, int>::iterator it = data.begin(); it != data.end(); it++)
	{
		map<int, int>::iterator it1 = it; it1++;
		int dy = abs(it1->second - it->second);
		int dx = abs(it1->first - it->first);
		
		double divide = (double)dy/dx;
		if(max < divide)
			max = divide;

		if(it1 == data.end())
			break;
	}
	
	cout << max;
	
	return 0;
}