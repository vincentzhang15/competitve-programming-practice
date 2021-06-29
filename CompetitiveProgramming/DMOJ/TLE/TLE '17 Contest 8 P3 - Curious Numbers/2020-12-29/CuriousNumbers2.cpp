#include <bits/stdc++.h>
using namespace std;

vector<long long> p;
long long num;
string s1, s2;
long long q, k, m, n;


int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	cin >> q >> k;
	
	for(int i = 1; i < 1000000; i++)
	{
		s1 = to_string(i);
		s2 = s1;
		reverse(s2.begin(), s2.end());
		num = stoll(s1 + s2);
		if(num % k == 0)
			p.push_back(num);
		
		s2 = s2.substr(1);
		num = stoll(s1 + s2);
		if(num % k == 0)
			p.push_back(num);
	}
	sort(p.begin(), p.end());
	
	for(int i = 0; i < q; i++)
	{
		cin >> m >> n;
		cout << lower_bound(p.begin(), p.end(), n+1) - lower_bound(p.begin(), p.end(), m) << endl;
	}
	
	return 0;
}