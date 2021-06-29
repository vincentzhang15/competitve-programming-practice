#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int c, n;
	cin >> c >> n;
	int data[4];
	memset(data, 0, sizeof(data));
	
	int sum = 0;
	int total = 0;
	for(int i = 0; i < c; i++)
	{
		string temp;
		cin >> temp;
		
		if(temp.compare("TOK") == 0)
		{
			sum += 1;
			data[0]++;
			total++;
		}
		else if(temp.compare("English") == 0)
		{
			sum += 2;
			data[1]++;
			total++;
		}
		else if(temp.compare("Chemistry") == 0)
		{
			sum += 3;
			data[2]++;
			total++;
		}
		else
		{
			sum += 4;
			data[3]++;
			total++;
		}
	}
	
	if(sum <= n)
		cout << "YEA BOI" << endl;
	else
	{
		cout << "Go to Metro" << endl;
		for(int i = 3; i >= 0; i--)
		{
			for(int j = 0; j < data[i]; j++)
			{
				total--;
				sum -= (i+1);
				if(sum <= n)
				{
					cout << total << endl;
					return 0;
				}
			}
		}
	}
	
	return 0;
}