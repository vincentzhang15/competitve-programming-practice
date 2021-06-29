#include <bits/stdc++.h>
using namespace std;

void calc(int n, int d)
{
	int newN = n;
	int newD = d;
	
	for(int i = 2; i <= n; i++)
	{
		if(newN % i == 0 && newD % i == 0)
		{
			newN /= i;
			newD /= i;
		}
	}
	
	cout << newN << "/" << newD << endl;
}

int main()
{
	int a, b;
	cin >> a >> b;
	
	if(a%b==0)
		cout << (a/b) << endl;
	else
	{
		if((a/b) != 0)
			cout << (a/b) << " ";
		calc((a%b), b);
	}
	
	return 0;
}