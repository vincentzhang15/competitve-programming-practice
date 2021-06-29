#include <iostream>
#include <map>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	map<string, char> code;
	for(int i = 0; i < n; i++)
	{
		char c;
		string s;
		
		cin >> c >> s;
		code[s] = c;
	}
	
	/*
	map<string, char>::iterator it;
	for(it = code.begin(); it != code.end(); it++)
	{
		cout << it->first << ":" << it->second << endl;
	}
	*/
	
	string sequence;
	cin >> sequence;

	map<string, char>::iterator itr;
	while(sequence.length() > 0)
	{
		int pos = -1;
		for(itr = code.begin(); itr != code.end(); itr++)
		{
			if(sequence.find(itr->first) == 0)
			{
				cout << itr->second;// << ":" << itr->first;
				pos = itr->first.length();
				sequence = sequence.substr(pos);
			}
		}
		//cout << endl << sequence << ":" << pos << endl;
	}
	cout << endl;
	
	
	
	return 0;
}