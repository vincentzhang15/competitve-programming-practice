#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int count = 0;
	
	int data[n];
	for(int i = 0; i < n; i++)
	{
		cin >> data[i];
	}
	
	for(int i = 1; i < n-1; i++)
	{
		if(data[i] > data[i-1] && data[i] < data[i+1])
			count++;
	}
	cout << count << endl;
	
	return 0;
}