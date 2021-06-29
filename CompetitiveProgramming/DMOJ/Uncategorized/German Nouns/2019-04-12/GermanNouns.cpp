#include <iostream>
using namespace std;

int main()
{
	string n;
	getline(cin, n);
	
	string s;
	while(getline(cin, s))
	{
		int count = 0;
		for(int i = 0; i < s.length(); i++)
			if(s[i] >= 'A' && s[i] <= 'Z')
				count++;
		cout << count << endl;
	}
	
	return 0;
}