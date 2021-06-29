#include <iostream>
#include <map>
#include <vector>
using namespace std;

map<int, vector<char>> data;
int points[4];
int total = 0;
int suit[4];

void print()
{
	map<int, vector<char>>::iterator it;
	cout << "Cards Dealt                                Points" << endl;
	int i = 0;
	for(it = data.begin(); it != data.end(); it++)
	{
		int count = 0;
		switch(it->first)
		{
			case 0: cout << "Clubs "; break;
			case 1: cout << "Diamonds "; break;
			case 2: cout << "Hearts "; break;
			case 3: cout << "Spades "; break;
		}
		
		for(char c : it->second)
		{
			count++;
			if(count != 1)
				cout << c << " ";
		}
		
		for(int j = 0; j < (45-(suit[i] + (count-1)*2)); j++)
			cout << " ";
		cout << "\t" << points[i];
		
		cout << endl;
		i++;
	}
	cout << "\t\t\t\t\t Total " << total << endl;
}

int main()
{
	for(int i = 0; i < 4; i++)
		points[i] = 0;
	
	suit[0] = 5+1;
	suit[1] = 8+1;
	suit[2] = 6+1;
	suit[3] = 6+1;
	
	data[0].push_back(' ');
	data[1].push_back(' ');
	data[2].push_back(' ');
	data[3].push_back(' ');
	
	int i = -1;
	int enter = 0;
	for(int j = 0; j < 17; j++)
	{
		char c;
		cin >> c;
		if(c == 'C' || c == 'D' || c == 'H' || c == 'S')
		{
			switch(enter)
			{
				case 0: points[i] += 3; break;
				case 1: points[i] += 2; break;
				case 2: points[i] += 1; break;
			}
			i++;
			enter = 0;
		}
		else
		{
			enter++;
			data[i].push_back(c);
			switch(c)
			{
				case 'A': points[i] += 4; break;
				case 'K': points[i] += 3; break;
				case 'Q': points[i] += 2; break;
				case 'J': points[i] += 1; break;
			}
			//cout << c << ":" << points[i] << endl;
		}
	}
	switch(enter)
	{
		case 0: points[3] += 3; break;
		case 1: points[3] += 2; break;
		case 2: points[3] += 1; break;
	}
			
	for(int i = 0; i < 4; i++)
	{
		total += points[i];
		//cout << points[i] << endl;
	}
	//cout << total << endl;
	
	print();
	
	return 0;
}