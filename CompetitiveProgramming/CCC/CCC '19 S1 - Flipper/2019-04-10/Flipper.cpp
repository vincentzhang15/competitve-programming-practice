#include <iostream>
using namespace std;

int main()
{
	string s;
	cin >> s;
	
	bool v = false;
	bool h = false;
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == 'V')
			v = !v;
		else
			h = !h;
	}
	
	if(v && !h)
		cout << 2 << " " << 1 << "\n" << 4 << " " << 3 << endl;
	else if(!v && h)
		cout << 3 << " " << 4 << "\n" << 1 << " " << 2 << endl;
	else if(!v && !h)
		cout << 1 << " " << 2 << "\n" << 3 << " " << 4 << endl;
	else
		cout << 4 << " " << 3 << "\n" << 2 << " " << 1 << endl;
	
	return 0;
}