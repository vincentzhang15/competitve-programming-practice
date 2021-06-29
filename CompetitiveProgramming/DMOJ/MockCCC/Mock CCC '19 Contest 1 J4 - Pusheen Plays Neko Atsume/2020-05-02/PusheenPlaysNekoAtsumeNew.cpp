#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	string food [] = {"Deluxe Tuna Bitz", "Bonito Bitz", "Sashimi", "Ritzy Bitz"};
	int data [4];
	memset(data, 0, sizeof(data));
	
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		if(s.compare("Deluxe") == 0)
		{
			string temp1, temp2;
			cin >> temp1 >> temp2;
			data[0]++;
		}
		else if(s.compare("Bonito") == 0)
		{
			string temp;
			cin >> temp;
			data[1]++;
		}
		else if(s.compare("Sashimi") == 0)
		{
			data[2]++;
		}
		else if(s.compare("Ritzy") == 0)
		{
			string temp;
			cin >> temp;
			data[3]++;
		}
	}
	
	for(int i = 100000; i > 0; i--)
	{
		for(int j = 0; j < 4; j++)
		{
			if(data[j] == i)
				cout << food[j] << " " << i << endl;
		}
	}
	
	return 0;
}