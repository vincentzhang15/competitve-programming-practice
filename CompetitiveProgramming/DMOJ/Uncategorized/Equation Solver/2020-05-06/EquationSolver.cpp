#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int sum;
	cin >> sum;
	string s;
	while(cin >> s)
	{
		if(s.compare("P") == 0)
		{
			int next;
			cin >> next;
			sum += next;
		}
		else if(s.compare("M") == 0)
		{
			int next;
			cin >> next;
			sum -= next;
		}
	}
	cout << sum << endl;
	
	return 0;
}