#include <iostream>
#include <cstring>
using namespace std;

int main()
{
	string s;
	cin >> s;
	
	string r = "IOSHZXN";
	for(int i = 0; i < strlen(s.c_str()); i++)
		if(r.find(s[i]) == -1)
		{
			cout << "NO" << endl;
			return 0;
		}
	cout << "YES" << endl;
	
	return 0;
}