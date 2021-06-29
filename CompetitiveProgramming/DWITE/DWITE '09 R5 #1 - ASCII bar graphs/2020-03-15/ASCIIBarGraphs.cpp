#include <bits/stdc++.h>
using namespace std;

int main()
{
	for(int i = 0; i < 5; i++)
	{
		int n;
		cin >> n;
		
		int L = 0;
		int R = 0;
		
		if(n < 0)
			L = abs(n);
		else if(n > 0)
			R = n;
		
		for(int i = 0; i < 5-L; i++)
			cout << "-";
		for(int i = 0; i < L; i++)
			cout << "*";
		
		cout << "|";

		for(int i = 0; i < R; i++)
			cout << "*";
		for(int i = 0; i < 5-R; i++)
			cout << "-";
		
		cout << endl;
	}
	
	return 0;
}