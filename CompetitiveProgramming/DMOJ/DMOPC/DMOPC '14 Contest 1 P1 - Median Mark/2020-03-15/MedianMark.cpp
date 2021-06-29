#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int data [n];
	
	for(int i = 0; i < n; i++)
		cin >> data[i];
	
	sort(data, data+n);
	
	if(n%2 != 0)
		cout << data[n/2] << endl;
	else
		cout << round((data[n/2]+data[n/2-1])/2.0) << endl;
	
	return 0;
}