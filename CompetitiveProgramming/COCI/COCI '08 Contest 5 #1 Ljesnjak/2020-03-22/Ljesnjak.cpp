#include <bits/stdc++.h>
using namespace std;

string s;

int count(string str)
{
	int count = 0;
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == str[0])
		{
			bool broke = false;
			for(int j = 1; j < str.length(); j++)
			{
				if(str[j] != s[i+j])
				{
					broke = true;
					break;
				}
			}
			if(!broke)
			{
				for(int k = i; k < i+str.length(); k++)
					s[k] = ' ';
				count++;
				//cout << i << " -------- " << str << ":" << s << ":" << count << ":" << str.length() << endl;
			}
		}
	}
	return (count!=0)?((count*str.length())-count):(0);
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	cin >> s;
	
	int letters = s.length();
	//cout << "letters ------- " << letters << endl;
	letters -= count("c=");
	//cout << "letters ------- " << letters << endl;
	letters -= count("c-");
	//cout << "letters ------- " << letters << endl;
	letters -= count("dz=");
	letters -= count("d-");
	letters -= count("lj");
	letters -= count("nj");
	letters -= count("s=");
	letters -= count("z=");
	
	cout << letters << "\n";
	
	return 0;
}