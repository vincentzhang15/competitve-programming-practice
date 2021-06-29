#include <iostream>
using namespace std;

int main()
{
	string s;
	cin >> s;
	
	int n = s.find("java");
	
	if(n == -1)
		cout << s.length() << endl;
	else
		cout << n << endl;
	
	return 0;
}