#include <iostream>
using namespace std;

int main()
{
	string a, b;
	cin >> a >> b;
	
	int x = stoi(a);
	
	if(a.length() != 3)
	{
		cout << "invalid" << endl;
		return 0;
	}
	if(b.length() != 7 )
	{
		cout << "invalid" << endl;
		return 0;
	}
	
	if(x == 416)
	{
		cout << "valuable" << endl;
		return 0;
	}
	if(x == 647 || x == 437)
	{
		cout << "valueless" << endl;
		return 0;
	}

	cout << "invalid" << endl;
	
	return 0;
}