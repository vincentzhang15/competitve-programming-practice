#include <bits/stdc++.h>
using namespace std;

bool isFav [720];

void calc()
{
	for(int i = 0; i < 720; i++)
		isFav[i] = false;
	isFav[34] = true;
	
	for(int i = 60; i < 720; i++)
	{
		int h = i/60;
		int m = i%60;
		
		string s = to_string(h) + ((m<10)?("0"+to_string(m)):(to_string(m)));
		int diff = (s[0]-'0') - (s[1]-'0');
		bool broke = false;
		for(int j = 0; j < s.length()-1; j++)
		{
			char c1 = s[j]-'0';
			char c2 = s[j+1]-'0';
			if(c1-c2 != diff)
			{
				broke = true;
				break;
			}
		}
		if(!broke)
		{
			isFav[i] = true;
		}
	}
}

int main()
{
	int m;
	cin >> m;
	
	calc();
	
	int totalTrue = 0;
	for(bool i : isFav)
		if(i)
			totalTrue++;
		
	int count = 0;
	count += (m/720)*totalTrue;
	
	for(int i = 0; i <= m%720; i++)
	{
		if(isFav[i])
			count++;
	}
	
	cout << count << endl;
	
	return 0;
}