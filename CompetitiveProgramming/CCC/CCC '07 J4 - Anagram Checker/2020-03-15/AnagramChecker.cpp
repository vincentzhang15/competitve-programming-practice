#include <bits/stdc++.h>
using namespace std;

int data[26];

void calc(int change)
{
	string line;
	getline(cin, line);
	
	for(int i = 0; i < line.length(); i++)
	{
		char c = line[i];
		data[c-'A'] += change;
	}
}

int main()
{
	calc(1);
	calc(-1);
	
	for(int i : data)
		if(i != 0)
		{
			cout << "Is not an anagram." << endl;
			return 0;
		}

	cout << "Is an anagram." << endl;
	
	return 0;
}