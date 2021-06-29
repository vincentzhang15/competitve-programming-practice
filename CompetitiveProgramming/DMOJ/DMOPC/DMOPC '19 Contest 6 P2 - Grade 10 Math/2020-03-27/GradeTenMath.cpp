#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a, b;
	cin >> a >> b;
	
	int count = 0;
	long long remain = 1;
	for(int i = b; i >= 1; i--)
	{
		int temp = i;
		while(temp % a == 0)
		{
			//cout << temp << ":" << count << endl;
			temp /= a;
			count++;
		}
		remain *= temp;
		while(remain % a == 0)
		{
			remain /= a;
			count++;
		}
	}
	cout << count << endl;
	
	return 0;
}