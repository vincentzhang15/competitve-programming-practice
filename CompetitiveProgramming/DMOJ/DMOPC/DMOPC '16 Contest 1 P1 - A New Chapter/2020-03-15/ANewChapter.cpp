#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		
		if(i%2 == a%2)
			count++;
	}
	cout << count << endl;
	
	return 0;
}