#include <bits/stdc++.h>
using namespace std;

int main()
{
	for(int i = 0; i < 5; i++)
	{
		int n;
		cin >> n;
		int m = n;
		
		int count = 0;
		for(int j = 2; j <= (int)sqrt(m);j++)
		{
			bool enter = false;
			while(true)
			{
				if(n % j != 0)
					break;
				n/=j;
				enter = true;
			}
			if(enter)
				count++;
			if(count > 3)
				break;
		}
		if(count == 3)
			cout << "valid" << endl;
		else
			cout << "not" << endl;
	}
	
	return 0;
}