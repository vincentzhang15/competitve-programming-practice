#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, n;
	cin >> a >> n;
	
	for(int i = 0; i < n; i++)
	{
		int m;
		cin >> m;
		
		if(abs(m-a) > 100)
			cout << "go away! 3:<" << endl;
		else
			cout << "fite me! >:3" << endl;
	}
}