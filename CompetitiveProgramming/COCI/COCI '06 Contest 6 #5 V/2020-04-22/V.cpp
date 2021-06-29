#include <bits/stdc++.h>
using namespace std;

set<char> data;
bool work(string number)
{
	for(int j = 0; j < number.length(); j++)
	{
		if(data.find(number[j]) == data.end())
		{
			return false;
		}
	}
	return true;
}

int main()
{
	long long x, a, b;
	scanf("%lld %lld %lld", &x, &a, &b);
	string s;
	cin >> s;

	if(s.length() == 10)
		printf("%d\n", ((int)b/x-(int)a/x));
	else
	{
		for(int i = 0; i < s.length(); i++)
		{
			data.insert(s[i]);
		}
		
		int count = 0;
		int start = (a%x==0)?(a/x):(a/x+1);
		int end = (b%x==0)?(b/x):(b/x+1);
		cout << start << ":" << end << endl;
		for(int i = start; i <= end; i++)
		{
			int num = x*i;
			string number = to_string(num);
			if(work(number))
				count++;
		}
		printf("%d\n", count);
	}
	
	return 0;
}