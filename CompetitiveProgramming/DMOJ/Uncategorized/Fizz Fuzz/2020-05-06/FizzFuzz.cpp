#include <bits/stdc++.h>
using namespace std;

void check(int n)
{
	if(n % 7 == 0 && n % 13 == 0)
		cout << "Fizz Fuzz";
	else if(n % 7 == 0)
		cout << "Fizz";
	else if(n % 13 == 0)
		cout << "Fuzz";
	else
		cout << n;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	int a = 1;
	int b = 1;
	
	for(int i = 0; i < n; i++)
	{
		check(a);
		cout << " ";
		check(b);
		cout << endl;
		
		a++;
		b+=2;
	}
	
	return 0;
}