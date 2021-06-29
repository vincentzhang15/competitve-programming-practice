#include <iostream>
using namespace std;

int main()
{
	string line;
	cin >> line;
	
	int one = (line[0] - '0') + (line[1] - '0') + (line[2] - '0');
	int two = (line[4] - '0') + (line[5] - '0') + (line[6] - '0');
	int three = (line[8] - '0') + (line[9] - '0') + (line[10] - '0') + (line[11] - '0');
	
	if(one == two && two == three)
		cout << "Goony!" << endl;
	else
		cout << "Pick up the phone!" << endl;
	
	return 0;
}