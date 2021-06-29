#include <iostream>
using namespace std;

int main()
{
	int s, e;
	cin >> s >> e;
	
	for(int i = s; i <= e; i++)
	{
		if((i-s)%60 == 0)
			cout << "All positions change in year " << i << endl;
	}
	
	return 0;
}