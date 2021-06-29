#include <iostream>
using namespace std;

int main()
{
	string s;
	getline(cin, s);
	
	int n = (s.length()-4)/4;
	
	if(n%2==0)
	{
		if(s[s.length()-2] == 'u')
			cout << "True" << endl;
		else
			cout << "False" << endl;
	}
	else
	{
		if(s[s.length()-2] == 'u')
			cout << "False" << endl;
		else
			cout << "True" << endl;
	}

	return 0;
}