#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	double max = -1;
	string name;
	for(int i = 0; i < n; i++)
	{
		string s;
		double m;
		
		cin >> s >> m;
		
		if(m > max)
		{
			max = m;
			name = s;
		}
	}
	cout << name << endl;
	
	return 0;
}