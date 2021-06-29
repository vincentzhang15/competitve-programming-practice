#include <bits/stdc++.h>
using namespace std;

int main()
{
	set<int> data;
	for(int i = 0; i < 10; i++)
	{
		int n;
		cin >> n;
		
		data.insert(n%42);
	}
	cout << data.size() << endl;
	
	return 0;
}