#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int p, q, w;
	cin >> p >> q >> w;
	
	double original = (p*(100.0-w)/100.0);
	double mark;
	for(int i = 0; i <= 100; i++)
	{
		mark = i*w/100.0;
		if(round(mark + original) >= q)
		{
			cout << i << endl;
			return 0;
		}
	}

	cout << "DROP THE COURSE" << endl;
	
	return 0;
}