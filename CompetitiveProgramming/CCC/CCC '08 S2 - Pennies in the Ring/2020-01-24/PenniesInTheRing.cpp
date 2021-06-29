#include <bits/stdc++.h>
using namespace std;

int main()
{
	int input, output;
	cin >> input;
	
	while(input != 0)
	{
		output = 0;
		
		for(int i = 1; i <= input; i++)
		{
			output += floor(sqrt(pow(input, 2)-pow(i, 2))) + 1;
			//cout << output << ":" << i << " -----------------" << endl;
		}
	
		cout << output*4+1 << endl;
		cin >> input;
	}
	
    return 0;
}