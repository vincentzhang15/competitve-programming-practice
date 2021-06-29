#include <iostream>
using namespace std;

int main()
{
	int n;
	string s;
	cin >> n >> s;
	
	int a = 0;
	int b = 0;
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == 'A')
			a++;
		else
			b++;
	}
	if(a > b)
		cout << "A" << endl;
	else if(b > a)
		cout << "B" << endl;
	else
		cout << "Tie" << endl;
	
	return 0;
}