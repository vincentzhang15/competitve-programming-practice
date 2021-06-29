#include <iostream>
using namespace std;

int main()
{
	int a, b;
	cin >> a >> b;
	
	int diff = b-a;
	if(diff <= 0)
		cout << "Congratulations, you are within the speed limit!" << endl;
	else if(diff >= 1 && diff <= 20)
		cout << "You are speeding and your fine is $100." << endl;
	else if(diff >= 21 && diff <= 30)
		cout << "You are speeding and your fine is $270." << endl;
	else
		cout << "You are speeding and your fine is $500." << endl;
	
	return 0;
}