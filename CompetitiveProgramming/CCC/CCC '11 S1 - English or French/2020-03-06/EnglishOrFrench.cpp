#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	cin >> ws;
	
	int s = 0, t = 0;
	
	for(int i = 0; i < n; i++)
	{
		string str;
		getline(cin, str);
		for(int j = 0; j < str.length(); j++)
		{
			if(str[j] == 'S' || str[j] == 's') s++;
			if(str[j] == 'T' || str[j] == 't') t++;
		}
	}
	
	cout << ((t>s)?("English"):("French")) << endl;
	
	return 0;
}