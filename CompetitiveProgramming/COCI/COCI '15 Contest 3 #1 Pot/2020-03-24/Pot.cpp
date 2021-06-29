#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	long long sum = 0;
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		int num = stoi(s.substr(0, s.length()-1));
		sum += pow(num, s[s.length()-1]-'0');
	}
	cout << sum << endl;
	
	return 0;
}