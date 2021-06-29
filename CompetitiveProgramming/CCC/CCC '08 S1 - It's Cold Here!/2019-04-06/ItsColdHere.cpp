#include <iostream>
#include <climits>
using namespace std;

int main()
{
	string finalCity;
	string city = " ";
	int min = INT_MAX;
	while(city != "Waterloo")
	{
		cin >> city;
		int temp;
		cin >> temp;
		if(temp < min)
		{
			min = temp;
			finalCity = city;
		}
	}
	
	cout << finalCity << endl;
	
	return 0;
}