#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int min = 1000000001;
	int max = -1000000001;
	for(int i = 0; i < n; i++)
	{
		int m;
		cin >> m;
		
		if(m<min)
			min = m;
		if(m>max)
			max = m;
	}
	
	cout << (max-min) << endl;
	
	return 0;
}