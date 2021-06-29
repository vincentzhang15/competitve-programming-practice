#include <bits/stdc++.h>
using namespace std;

int main()
{
	int count = 0;
	for(int i = 0; i < 5; i++)
	{
		char c;
		cin >> c;
		
		if(c == 'P')
			count++;
	}
	cout << count << endl;
	
	return 0;
}