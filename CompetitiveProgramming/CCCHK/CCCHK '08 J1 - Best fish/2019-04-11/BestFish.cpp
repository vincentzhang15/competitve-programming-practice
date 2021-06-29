#include <iostream>
using namespace std;

int main()
{
	int c;
	cin >> c;
	int cMax = 0;
	for(int i = 0; i < c; i++)
	{
		int a, b;
		cin >> a >> b;
		if(a*b > cMax)
			cMax = a*b;
	}

	int n;
	cin >> n;
	int nMax = 0;
	for(int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		if(a*b > nMax)
			nMax = a*b;
	}
	
	if(cMax > nMax)
		cout << "Casper" << endl;
	else if(nMax > cMax)
		cout << "Natalie" << endl;
	else
		cout << "Tie" << endl;
	
	return 0;
}