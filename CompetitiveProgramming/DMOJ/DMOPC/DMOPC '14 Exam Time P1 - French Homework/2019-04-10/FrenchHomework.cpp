#include <iostream>
using namespace std;

int main()
{
	string a, b;
	cin >> a >> b;
	cout << a << "-tu ";
	
	if(b[b.length()-1] == 's')
		cout << "les ";
	else if(b[b.length()-1] == 'e')
		cout << "la ";
	else
		cout << "le ";
	
	cout << b << " ?" << endl;
	
	return 0;
}