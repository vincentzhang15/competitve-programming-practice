#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int tides [n];
	for(int i = 0; i < n; i++)
		cin >> tides[i];
	
	int num = sizeof(tides)/sizeof(tides[0]);
	sort(tides, tides+num);
	
	for(int i = 0; i <= n/2; i++)
	{
		if(n == 1)
		{
			cout << tides[0] << endl;
			break;
		}
		
		if(n%2==0 && i==n/2)
			break;
		
		int low = n%2==0?n/2-1-i:n/2-i;
		int high = n%2==0?n/2+i:n/2+i+1;
		
		cout << tides[low] << " " << tides[high] << " ";
	}
	
	return 0;
}