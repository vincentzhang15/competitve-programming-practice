#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		if(s.length() != 10)
			cout << "not a phone number" << endl;
		else
		{
			if((s[0] == '4' && s[1] == '1' && s[2] == '6') || (s[0] == '6' && s[1] == '4' && s[2] == '7'))
			{
				cout << "(" << s[0] << s[1] << s[2] << ")-" << s[3] << s[4] << s[5] << "-" << s[6] << s[7] << s[8] << s[9] << endl;
			}
			else
				cout << "not a phone number" << endl;
		}
	}
	
	return 0;
}