#include <bits/stdc++.h>
using namespace std;

int main()
{
	string conversion [4][3] = {{"gal", "qt", "4"}, {"qt", "pt", "2"}, {"pt", "gill", "4"}, {"gill", "oz", "5"}};

	for(int z = 0; z < 5; z++)
	{
		int base;
		string from, to, temp;
		cin >> base >> from >> temp >> to;
		
		if(from.compare(to) == 0)
		{
			cout << base << endl;
			continue;
		}
		
		int indexFrom = -1;
		int indexTo = -1;
		
		for(int i = 0; i < 4; i++)
		{
			if(conversion[i][0].compare(from) == 0)
				indexFrom = i;
			if(conversion[i][1].compare(to) == 0)
				indexTo = i;
		}
		
		if(indexFrom > indexTo || indexFrom == -1 || indexTo == -1)
		{
			temp = from;
			from = to;
			to = temp;
			for(int i = 0; i < 4; i++)
			{
				if(conversion[i][0].compare(from) == 0)
					indexFrom = i;
				if(conversion[i][1].compare(to) == 0)
					indexTo = i;
			}
			for(int i = indexFrom; i <= indexTo; i++)
			{
				base /= stoi(conversion[i][2]);
			}
		}
		else
		{
			for(int i = indexFrom; i <= indexTo; i++)
			{
				base *= stoi(conversion[i][2]);
			}
		}
		
		cout << base << endl;
	}
	
	return 0;
}