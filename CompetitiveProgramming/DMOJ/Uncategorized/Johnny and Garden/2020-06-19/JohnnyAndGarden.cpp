#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	string line1;
	getline(cin, line1);
	
	cout << "\"";
	bool enter = false;
	for(int i = 0; i < line1.length(); i++)
	{
		char c = line1[i];
		if(c == '.')
		{
			enter = true;
			cout << "\" - ";
			
		}
		else
		{
			if(enter)
				cout << (char)tolower(c);
			else
				cout << c;
		}
	}
	
	if(!enter)
	{
		string line2;
		getline(cin, line2);
		cout << "\" - ";
		for(int i = 0; i < line2.length(); i++)
			cout << (char)tolower(line2[i]);
	}
	cout << endl;
	
	return 0;
}