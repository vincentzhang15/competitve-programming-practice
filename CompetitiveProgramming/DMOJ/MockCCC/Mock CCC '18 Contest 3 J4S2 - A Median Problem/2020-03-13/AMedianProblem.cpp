#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int col [n];
	int row [n];
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
			cin >> row[j];

		sort(row, row+n);
		col[i] = row[n/2];
	}
	
	sort(col, col+n);
	cout << col[n/2] << endl;
	
	return 0;
}