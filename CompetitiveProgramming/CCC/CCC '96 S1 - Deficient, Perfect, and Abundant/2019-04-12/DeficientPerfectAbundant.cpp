#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		int count = 0;
		for(int j = 1; j < num; j++)
		{
			if(num % j == 0)
				count += j;
		}
		if(count < num)
			cout << num << " is a deficient number." << endl;
		else if(count > num)
			cout << num << " is an abundant number." << endl;
		else
			cout << num << " is a perfect number." << endl;
	}
	
	return 0;
}