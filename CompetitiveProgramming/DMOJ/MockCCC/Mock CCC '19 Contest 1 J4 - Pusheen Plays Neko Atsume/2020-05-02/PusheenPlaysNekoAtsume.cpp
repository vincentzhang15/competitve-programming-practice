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
	
	int sum = 0;
	int max = -1;
	int maxi = -1;
	int min = INT_MAX;
	int mini = INT_MAX;
	for(int i = 0; i < 4; i++)
	{
		if(data[i] > max)
		{
			max = data[i];
			maxi = i;
		}
		if(data[i] < min)
		{
			min = data[i];
			mini = i;
		}
		sum += data[i];
	}
	
	
	
	if(max != 0)
	{
		cout << food[maxi] << " " << max << endl;
	}
	else
		return 0;
	
	for(int i = 0; i < 4; i++)
	{
		if(i != maxi && i != mini)
		{
			int j = 6-maxi-mini-i;
			if(data[i] >= data[j] && data[i] != 0)
			{
				cout << food[i] << " " << sum-max-min-data[j] << endl;
				if(data[j] != 0)
				{
					cout << food[j] << " " << sum-max-min-data[i] << endl;
				}
				else
					return 0;
			}
			else if(data[i] <= data[j] && data[j] != 0)
			{
				cout << food[j] << " " << sum-max-min-data[i] << endl;
				if(data[i] != 0)
				{
					cout << food[i] << " " << sum-max-min-data[j] << endl;
				}
				else
					return 0;
			}
			else
				return 0;
		}
	}
	if(min != 0)
	{
		cout << food[mini] << " " << min << endl;
	}
	
	return 0;
}