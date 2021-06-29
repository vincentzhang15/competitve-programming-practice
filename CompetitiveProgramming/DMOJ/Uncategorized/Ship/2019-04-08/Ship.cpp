#include <iostream>
using namespace std;

int main()
{
	string s;
	cin >> s;
	
	bool hasAll = true;
	
	if(s.find("B") == -1)
	{
		cout << "B" << endl;
		hasAll = false;
	}
	if(s.find("F") == -1)
	{
		cout << "F" << endl;
		hasAll = false;
	}
	if(s.find("T") == -1)
	{
		cout << "T" << endl;
		hasAll = false;
	}
	if(s.find("L") == -1)
	{
		cout << "L" << endl;
		hasAll = false;
	}
	if(s.find("C") == -1)
	{
		cout << "C" << endl;
		hasAll = false;
	}
	
	if(hasAll)
		cout << "NO MISSING PARTS" << endl;
	
	return 0;
}