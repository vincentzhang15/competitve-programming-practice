#include <iostream>
using namespace std;

int main()
{
	int data [21];
	data[11] = 99948;
	data[12] = 90387;
	data[10] = 89613;
	data[13] = 80000;
	data[9 ] = 79959;
	data[8 ] = 70202;
	data[14] = 70142;
	data[15] = 60213;
	data[7 ] = 59822;
	data[6 ] = 50075;
	data[16] = 50009;
	data[5 ] = 40026;
	data[17] = 39974;
	data[4 ] = 29929;
	data[18] = 29874;
	data[3 ] = 20129;
	data[19] = 19720;
	data[20] = 10011;
	data[2 ] = 9967;
	
	for(int i = 0; i < 1000000; i++)
	{
		while(1)
		{
			int num = (rand()%19)+2;
			if(data[num] > 0)
			{
				data[num]--;
				printf("%d\n", num);
				break;
			}
		}
	}

	return 0;
}