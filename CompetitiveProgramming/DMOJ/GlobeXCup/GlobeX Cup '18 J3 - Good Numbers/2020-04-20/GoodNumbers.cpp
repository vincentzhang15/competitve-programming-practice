#include <bits/stdc++.h>
using namespace std;

int main()
{
	bool isPrime[100001];
	memset(isPrime, true, sizeof(isPrime));
	isPrime[0] = false;
	isPrime[1] = false;
	
	for(int i = 2; i < 100001; i++)
	{
		if(isPrime[i])
		{
			for(int j = 2; j <= (int)(100001/i); j++)
			{
				isPrime[i*j] = false;
			}
		}
	}
	
	int n;
	cin >> n;
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		int num = stoi(s);
		int digit = 0;
		for(int j = 0; j < s.length(); j++)
		{
			digit += (int)(s[j]-'0');
		}
		
		if(isPrime[num] && isPrime[digit])
		{
			count++;
		}
	}
	cout << count << endl;
	
	return 0;
}