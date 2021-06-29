#include <iostream>
using namespace std;

int main()
{
	int k;
	cin >> k;
	string s;
	cin >> s;
	
	for(int i = 0; i < s.length(); i++)
	{
		int shift = 3*(i+1) + k;
		cout << (char)((((s[i] - 'A') - shift + 26)%26) + 'A');
	}
	cout << endl;
	
	return 0;
}