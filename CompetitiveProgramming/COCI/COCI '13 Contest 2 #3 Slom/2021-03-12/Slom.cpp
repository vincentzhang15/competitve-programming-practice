#include <bits/stdc++.h>
using namespace std;

int n;
string s;
string original;

void calc()
{
	if(s.length()%2==0)
	{
		for(int i = s.length()-3; i >= 0; i--)
			if(i%2!=0)
			{
				s = s.substr(0, i) + s.substr(i+1, s.length()-1-i) + s[i];
	//cout << i << ":" << n << endl << s << endl; ///////////////////
			}
	}
	else
	{
		for(int i = s.length()-2; i >= 0; i--)
			if(i%2!=0)
				s = s.substr(0, i) + s.substr(i+1, s.length()-i-1) + s[i];
	}
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	cin >> n >> s;
	//cout << n << endl << s << endl; ///////////////////
	original = s;
	string data [10000];
	int ind = 0;
	
	int period = n+1;
	data[ind++] = s;
	for(int i = 0; i < n; i++)
	{
		calc();
		if(s.compare(original) == 0)
		{
			period = i+1;
			break;
		}
		data[ind++] = s;
	}
	cout << data[n%period] << endl;
	return 0;
}