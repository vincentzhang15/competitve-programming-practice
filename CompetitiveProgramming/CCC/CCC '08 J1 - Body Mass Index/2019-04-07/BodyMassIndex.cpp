#include <iostream>
using namespace std;

int main()
{
	double weight, height;
	cin >> weight >> height;
	double bmi = weight/(height*height);
	
	if(bmi > 25.0)
		cout << "Overweight" << endl;
	else if(bmi < 18.5)
		cout << "Underweight" << endl;
	else
		cout << "Normal weight" << endl;
	
	return 0;
}