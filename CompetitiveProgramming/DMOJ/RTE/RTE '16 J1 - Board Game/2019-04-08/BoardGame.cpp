#include <iostream>
using namespace std;

int main()
{
	string s;
	getline(cin, s);
	
	int count = 0;
	int maxLen = 0;
	int len = 0;
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == 'L')
			len++;
		else if(s[i] != ' ')
			len = 0;
		
		if(maxLen < len)
			maxLen = len;
		
		if(s[i] == 'L')
			count++;
	}
	cout << count << " " << maxLen << endl;
	
	return 0;
}