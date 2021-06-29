#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, h;
	cin >> n >> h;
	
	n/=2;
	int a [n];
	int b [n];
	for(int i = 0; i < n; i++)
	{
		cin >> a[i];
		cin >> b[i];
	}
	/*
	for(int i : a)
		cout << i << " ";
	cout << endl;
	for(int i : b)
		cout << i << " ";
	cout << endl;
	cout << endl;
	*/
	
	sort(a, a+n);
	sort(b, b+n);
	
	/*
	for(int i : a)
		cout << i << " ";
	cout << endl;
	for(int i : b)
		cout << i << " ";
	cout << endl;
	*/
	
	int count = 0;
	int min = INT_MAX;
	for(int i = 0; i < h; i++)
	{
		int crash = (n-(int)(lower_bound(a, a+n, i+1)-a))+(n-(int)(lower_bound(b, b+n, h-i)-b));
		if(crash < min)
		{
			min = crash;
			count = 1;
		}
		else if(min == crash)
			count++;
	}

	cout << min << " " << count << endl;
	
	return 0;
}