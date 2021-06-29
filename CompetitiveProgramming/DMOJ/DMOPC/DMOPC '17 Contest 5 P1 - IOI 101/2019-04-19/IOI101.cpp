#include <iostream>
using namespace std;

int main()
{
	string s;
	getline(cin, s);

	for(int i = 0; i < s.length(); i++)
	{
		switch(s[i])
		{
			case '0': cout << "O"; break;
			case '1': cout << "l"; break;
			case '3': cout << "E"; break;
			case '4': cout << "A"; break;
			case '5': cout << "S"; break;
			case '6': cout << "G"; break;
			case '8': cout << "B"; break;
			case '9': cout << "g"; break;
			default: cout << s[i];
		}
	}
	cout << endl;
	
	return 0;
}