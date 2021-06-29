#include <iostream>
using namespace std;

int main()
{
	int a, b, c, d;
	cin >> a >> b >> c >> d;
	
	int count = 0;
	switch(a)
	{
		case 1: count += 461; break;
		case 2: count += 431; break;
		case 3: count += 420; break;
	}
	
	switch(b)
	{
		case 1: count += 100; break;
		case 2: count += 57; break;
		case 3: count += 70; break;
	}
	
	switch(c)
	{
		case 1: count += 130; break;
		case 2: count += 160; break;
		case 3: count += 118; break;
	}
	
	switch(d)
	{
		case 1: count += 167; break;
		case 2: count += 266; break;
		case 3: count += 75; break;
	}
	cout << "Your total Calorie count is " << count << "." << endl;
	
	return 0;
}