#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int sum = 0;
	for(int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		sum += a;
	}
	
	if(sum > 200)
		cout << "Over maximum capacity!" << endl;
	else
		cout << 200-sum << endl;
	
	return 0;
}