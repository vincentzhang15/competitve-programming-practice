#include <iostream>
using namespace std;

int main()
{
	int square = 1;
	int input;
	
	while(1)
	{
		cin >> input;
		if(input == 0)
		{
			cout << "You Quit!";
			return 0;
		}
		square += input;
		
		switch(square)
		{
			case 9: square = 34; break;
			case 40: square = 64; break;
			case 67: square = 86; break;
			case 54: square = 19; break;
			case 90: square = 48; break;
			case 99: square = 77; break;
		}
		if(square > 100)
			square -= input;

		cout << "You are now on square " << square << endl;
		if(square == 100)
		{
			cout << "You Win!";
			return 0;
		}
		
	}
	
	return 0;
}