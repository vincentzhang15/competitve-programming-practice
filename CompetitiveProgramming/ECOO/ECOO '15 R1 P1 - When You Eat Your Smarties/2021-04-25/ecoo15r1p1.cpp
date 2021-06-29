#include<bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);

	for(int k = 0; k< 10; k++)
	{
		int data[8];
		memset(data, 0, sizeof(data));

		string line;
		cin >> line;
		while(line != "end")
		{
			if(line.compare("orange") == 0) data[0]++;
			if(line.compare("blue") == 0) data[1]++;
			if(line.compare("green") == 0) data[2]++;
			if(line.compare("yellow") == 0) data[3]++;
			if(line.compare("pink") == 0) data[4]++;
			if(line.compare("violet") == 0) data[5]++;
			if(line.compare("brown") == 0) data[6]++;
			if(line.compare("red") == 0) data[7]++;
			
			cin >> line;
		}
		int total = 0;
		for(int i = 0; i < 7; i++)
			total += ceil(data[i]/7.0)*13.0;
		total += data[7]*16.0;
		cout << total << "\n";
	}
	
	return 0;
}