#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int first0 = -1;
	int last0 = -1;
	int last = -1;
	int data [n];
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		int cur;
		cin >> cur;
		if(i-1 >= 0 && data[i-1] != 0)
		{
			count++;
			data[i] = cur;
		}
		
		if(cur < last && cur != 0)
		{
			cout << "NO" << endl;
			return 0;
		}
		
		if(cur == 0)
		{
			if(first0 == -1)
				first0 = i;
		}
		
		if(cur != 0)
			last = cur;
	}
	
	for(int i = n-1; i >= 0; i--)
		if(data[i] == 0)
			last0 = i;
	
	int firstd;
	int lastd;
	if(first0+1 < n)
		firstd = first0+1;
	else
		firstd = first0-1;
	if(last0-1 < 0)
		last0 = last0+1;
	else
		last0 = last0-1;
	
	if(firstd == lastd)
		cout << "YES" << endl;
	else
		cout << "NO" << endl;
	
	//cout << first0 << ":" << last0 << endl;
	//cout << firstd << ":" << lastd << endl;
	
	return 0;
}