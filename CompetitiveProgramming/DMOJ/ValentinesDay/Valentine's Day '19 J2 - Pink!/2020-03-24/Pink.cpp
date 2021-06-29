#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		
		if((a >= 240 && a <= 255) && (b >= 0 && b <= 200) && (c >= 95 && c <= 220))
			count++;
	}
	cout << count << endl;
	
	return 0;
}