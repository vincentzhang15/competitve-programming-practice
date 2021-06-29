#include <bits/stdc++.h>
using namespace std;

int main()
{
	long long a, b;
	cin >> a >> b;
	
	long long sum = a+b;
	long long diff = llabs(a-b);
	long long prod = a*b;
	
	if(sum > diff && sum > prod)
		cout << sum << endl;
	else if(diff > sum && diff > prod)
		cout << diff << endl;
	else
		cout << prod << endl;
	
	return 0;
}