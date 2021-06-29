#include <bits/stdc++.h>
using namespace std;

int main()
{
	string s;
	cin >> s;
	
	int data [26];
	memset(data, 0, sizeof(data));
	
	int max1 = -1;
	for(int i = 0; i < s.length(); i++)
	{
		data[s[i] - 'a']++;
		if(data[s[i] - 'a'] > max1)
			max1 = data[s[i] - 'a'];
	}

	int count = 0;
	for(int i : data)
	{
		//cout << i << endl;
		if(i != 0)
			count++;
	}
	
	for(int i = 0; i < 26; i++)
		if(data[i] == max1)
		{
			data[i] = 0;
			break;
		}
	
	int max2 = -1;
	for(int i = 0; i < 26; i++)
	{
		if(data[i] > max2)
			max2 = data[i];
	}

	
	//cout << s.length() << ":" << max1 << ":" << max2 << endl;
	if(count <= 2)
		cout << 0 << endl;
	else
		cout << (s.length()-max1-max2) << endl;
	
	return 0;
}