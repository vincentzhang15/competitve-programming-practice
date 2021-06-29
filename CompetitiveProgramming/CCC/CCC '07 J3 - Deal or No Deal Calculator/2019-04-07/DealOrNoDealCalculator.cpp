#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int nums [] = {100, 500, 1000, 5000, 10000, 25000, 50000, 100000, 500000, 1000000};
	int sum = 0;
	for(int i = 0; i < 10; i++)
		sum += nums[i];
	
	int count = 10;
	for(int i = 0; i < n; i++)
	{
		int box;
		cin >> box;
		count--;
		sum -= nums[box-1];
	}
	
	int offer;
	cin >> offer;
	
	if(offer > sum/count)
		cout << "deal" << endl;
	else
		cout << "no deal" << endl;
	
	return 0;
}