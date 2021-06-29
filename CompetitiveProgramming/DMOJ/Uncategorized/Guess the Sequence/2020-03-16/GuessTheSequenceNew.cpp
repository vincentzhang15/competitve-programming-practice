#include <iostream>
using namespace std;

int main()
{
	int data [] = {1, 3, 3, 2, 2, 1, 3, 3, 3, 1, 2, 3, 1, 1, 1};
	for(int i = 0; i < 15; i++)
	{
		cout << data[i] << endl;
		string temp;
		cin >> temp;
	}
	
	/*
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
	}*/

	return 0;
}