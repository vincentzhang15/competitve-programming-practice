#include <bits/stdc++.h>
using namespace std;

int main()
{
	bool first = false;
	int count = 0;
	
	for(int i = 0; i < 7; i++)
	{
		char c;
		cin >> c;
		
		if(c == 'T')
			first = false;
		
		if(c == 'J' && !first)
		{
			count++;
			first = true;
		}
	}
	cout << count << endl;
	
	return 0;
}