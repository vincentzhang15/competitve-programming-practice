#include <bits/stdc++.h>
using namespace std;

int main()
{
	string temp1;
	getline(cin, temp1);
	string temp2;
	getline(cin, temp2);

	int a = stoi(temp2);
	
	string s;
	getline(cin, s);
	
	for(int i = 0; i < s.length(); i++)
	{
		char c = s[i];
		
		if(c == ' ')
			cout << " ";
		else
			cout << (char)((((c-'a')+a)%26)+'a');
	}
	cout << endl;
	
	return 0;
}