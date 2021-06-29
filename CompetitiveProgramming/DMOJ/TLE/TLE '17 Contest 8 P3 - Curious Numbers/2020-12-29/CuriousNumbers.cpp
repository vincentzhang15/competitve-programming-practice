#include <bits/stdc++.h>
using namespace std;

set<long long> p;
int q, k;

void remove()
{
	for(auto i : p)
		cout << i << endl;
}

long long toInt(const char * str)
{
    long long val = 0;
    while( *str ) {
        val = val*10 + (*str++ - '0');
    }
    return val;
	/*
	long long n = 0;
	for(auto c : s)
		n = n*10 + (int)(c-'0');
	return n;
	*/
}

void generate(string s)
{
	for(int i = 0; i <= 9; i++)
	{
		string temp = to_string(i) + s + to_string(i);
		if(temp.size() > 10)
			continue;
		long long n = toInt(temp.c_str());
		if(p.find(n) == p.end())
		{
			if(n % 10 != 0 && n % k == 0)
				p.insert(n);
			generate(temp);
		}
	}
}


int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> q >> k;
	for(int i = 0; i <= 9; i++)
	{
		if(i % 10 != 0 && i % k == 0)
			p.insert(i);
		generate(to_string(i));
	
	}
	for(int i = 0; i <= 9; i++)
	{
		int n = i*10+i;
		if(n % 10 != 0 && n % k == 0)
			p.insert(n);
		string str = to_string(i) + to_string(i) + "";
		generate(str);
	}
	//remove();
	
	for(int i = 0; i < q; i++)
	{
		int m, n;
		cin >> m >> n;
		//cout << *p.lower_bound(m) << endl;
		//cout << *p.lower_bound(n) << endl;
		
		if(*p.lower_bound(n) == n)
			cout << distance(p.lower_bound(m), p.lower_bound(n+1)) << endl;
		else
			cout << distance(p.lower_bound(m), p.lower_bound(n)) << endl;
	}
	return 0;
}