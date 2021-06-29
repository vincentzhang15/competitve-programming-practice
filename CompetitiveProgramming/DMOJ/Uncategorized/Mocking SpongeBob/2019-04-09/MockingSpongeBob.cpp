#include <iostream>
using namespace std;

int main()
{
	string s;
	getline(cin, s);
	
	while(getline(cin, s))
	{
		bool count = false;
		for(int i = 0; i < s.length(); i++)
		{
			if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z'))
			{
				count = !count;
				if(count)
					cout << (char)tolower(s[i]);
				else
					cout << (char)toupper(s[i]);
			}
			else
				cout << s[i];
		}
		
		cout << endl;
	}
	
	return 0;
}