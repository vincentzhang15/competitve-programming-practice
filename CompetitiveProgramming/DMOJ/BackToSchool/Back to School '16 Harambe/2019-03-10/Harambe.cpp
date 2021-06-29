#include <iostream>
using namespace std;

int main()
{
	string s;
	getline(cin, s);

	int upper = 0;
	int lower = 0;
	
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] >= 'a' && s[i] <= 'z')
			lower++;
		else if(s[i] >= 'A' && s[i] <= 'Z')
			upper++;
	}
	
	if(lower > upper)
	{
		string str = "";
		for(int i = 0; i < s.length(); i++)
		{
			str += tolower(s[i]);
		}
		cout << str << endl;
	}
	else if(upper > lower)
	{
		string str = "";
		for(int i = 0; i < s.length(); i++)
		{
			str += toupper(s[i]);
		}
		cout << str << endl;
	}
	else
		cout << s << endl;
	
	return 0;
}