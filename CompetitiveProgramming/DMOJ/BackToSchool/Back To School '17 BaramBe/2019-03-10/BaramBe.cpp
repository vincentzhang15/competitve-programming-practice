#include <iostream>
using namespace std;

int main()
{
	string s;
	getline(cin, s);
	
	for(int i = 0; i < s.length(); i++)
	{
		if(i == s.length()-1)
			printf("%c.", s[i]);
		else if (i < s.length()-2)
		{
			if(s[i+2] >= 'A' && s[i+2] <= 'Z')
				printf("%c.", s[i]);
			else
				printf("%c", s[i]);
		}
		else
			printf("%c", s[i]);
	}
	
	return 0;
}