#include <iostream>
#include <climits>
using namespace std;

int main()
{
	while(1)
	{
		int n;
		cin >> n;
		
		if(n == 0)
			return 0;

		int w = 0;
		int l = 0;
		int width = 0;
		int length = 0;
		int perimeter = INT_MAX;

		for(int i = 1; i <= n/2+1; i++)
		{
			if(n % i == 0)
			{
				width = n/i;
				length = n/width;
				if((width+length)*2 < perimeter)
				{
					perimeter = (width+length)*2;
					w = width;
					l = length;
				}
			}
		}
		cout << "Minimum perimeter is " << perimeter << " with dimensions " << w << " x " << l << endl;
	}
	return 0;
}