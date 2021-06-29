#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int lmin = 1000001;
	int rmin = 1000001;
	int lmax = -1000001;
	int rmax = -1000001;
	
	for(int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		
		if(a < lmin)
			lmin = a;
		if(a > lmax)
			lmax = a;
		if(b < rmin)
			rmin = b;
		if(b > rmax)
			rmax = b;
	}
	cout << ((lmax-lmin)+(rmax-rmin))*2 << endl;
	
	return 0;
}