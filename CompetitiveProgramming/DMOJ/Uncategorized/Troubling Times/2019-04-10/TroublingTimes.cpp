#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int n, d;
	cin >> n >> d;
	int intervals [n];
	for(int i = 0; i < n; i++)
		cin >> intervals[i];
	
	sort(intervals, intervals + n);

	for(int i = n-1; i >= 0; i--)
	{
		if(d % intervals[i] == 0)
		{
			cout << abs(d/intervals[i]) << endl;
			return 0;
		}
	}
	cout << "This is not the best time for a trip." << endl;
	
	return 0;
}