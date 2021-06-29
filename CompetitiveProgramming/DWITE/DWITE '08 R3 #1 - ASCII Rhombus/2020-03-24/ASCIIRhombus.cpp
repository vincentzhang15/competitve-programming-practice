#include <bits/stdc++.h>
using namespace std;

int main()
{
	for(int i = 0; i < 5; i++)
	{
		int n;
		cin >> n;
		
		int count = 1;
		for(int i = 0; i < n; i++)
		{
			if(i == n/2)
				count = n;
			
			int other = (n-count)/2;
			for(int k = 0; k < other; k++)
				cout << ".";
			for(int k = 0; k < count; k++)
				cout << "#";
			for(int k = 0; k < other; k++)
				cout << ".";

			if(i < n/2)
				count += 2;
			else if(i >= n/2)
				count -= 2;
			
			cout << endl;
		}
	}
	
	return 0;
}