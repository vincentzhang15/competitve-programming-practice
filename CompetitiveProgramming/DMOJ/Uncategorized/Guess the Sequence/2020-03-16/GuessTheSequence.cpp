#include <iostream>
using namespace std;

int main()
{
	while(true)
	{
		for(int i = 3; i >= 1; i--)
		{
			printf("%d\n", i);
			string out;
			cin >> out;
			//scanf("%s", out);
			if(out == "YES")
				break;
			else if(out == "DONE")
				return 0;
		}
	}
	
	return 0;
}