#include <iostream>
#include <string.h>
using namespace std;

int main()
{
	while(1)
	{
		string s;
		cin >> s;
		if(s == "quit!")
			return 0;
		
		int len = strlen(s.c_str());
		if(len > 4)
		{
			string v = "aeiouy";
			if(s[len-1] == 'r' && s[len-2] == 'o' && s[len-3] >= 'a' && s[len-3] <= 'z' && v.find(s[len-3]) == -1)
			{
				for(int i = 0; i < len-2; i++)
					cout << s[i];
				cout << "our" << endl;
				continue;
			}
		}
		cout << s << endl;
	}
	return 0;
}