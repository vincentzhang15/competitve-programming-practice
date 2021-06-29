#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		for(int j = 0; j < s.length(); j++)
		{
			switch(s[j])
			{
				case 'a': case 'A':
					cout << "Hi! ";
					break;
				case 'e': case 'E':
					cout << "Bye! ";
					break;
				case 'i': case 'I':
					cout << "How are you? ";
					break;
				case 'o': case 'O':
					cout << "Follow me! ";
					break;
				case 'u': case 'U':
					cout << "Help! ";
					break;
				case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
					cout << "Yes! ";
					break;
			}
		}
		cout << endl;
	}
	
	return 0;
}