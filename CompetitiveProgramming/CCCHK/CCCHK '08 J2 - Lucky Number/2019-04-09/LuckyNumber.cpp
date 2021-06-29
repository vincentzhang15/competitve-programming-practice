#include <iostream>
#include <string>
using namespace std;

int main()
{
	int cases;
	cin >> cases;
	
	for(int i = 0; i < cases; i++)
	{
		string n;
		cin >> n;
		
		while(true)
		{
		    int sum = 0;
			if(n.length() == 1)
			{
				cout << n << endl;
				break;
			}
			else
			{
				for(int j = 0; j < n.length(); j++)
				{
					sum += n[j] - '0';
				}
				n = to_string(sum);
				// cout << n << " --> ";
			}
		}
	}
	
	return 0;
}