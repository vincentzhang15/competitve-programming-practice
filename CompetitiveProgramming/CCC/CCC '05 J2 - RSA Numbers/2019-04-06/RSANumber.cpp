#include <iostream>
using namespace std;

int main()
{
	int s, e;
	cin >> s >> e;
	
	int RSA = 0;
	for(int i = s; i <= e; i++)
	{
		int count = 0;
		for(int j = 1; j < i/2; j++)
		{
			if(i % j == 0)
				if(j > i/j)
					break;
				else if (j == i/j)
					count ++;
				else
					count += 2;
		}
		if(count == 4)
			RSA ++;
	}
	cout << "The number of RSA numbers between " << s << " and " << e << " is " << RSA << endl;
	
	return 0;
}