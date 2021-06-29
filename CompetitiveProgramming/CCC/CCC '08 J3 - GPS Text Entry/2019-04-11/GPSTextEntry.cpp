#include <iostream>
using namespace std;

int x(char c)
{
	if(c == ' ' || c == '-' || c == '.' || c == '+')
		return 4;
	else
		return (c - 'A')/6;
}

int y(char c)
{
	if(c == ' ')
		return 2;
	else if(c == '-')
		return 3;
	else if(c == '.')
		return 4;
	else if(c == '+')
		return 5;
	else
		return (c - 'A')%6;
}

int main()
{
	string s;
	getline(cin, s);
	s = "A" + s + "+";
	
	int data[s.length()][2];
	
	int steps = 0;
	for(int i = 0; i < s.length(); i++)
	{
		data[i][0] = x(s[i]);
		data[i][1] = y(s[i]);
	}
	
	int count = 0;
	for(int i = 1; i < s.length(); i++)
	{
		for(int j = 0; j < 2; j++)
			count += abs(data[i][j]-data[i-1][j]);
	}
	cout << count << endl;
	
	/*

	for(int i = 0; i < s.length(); i++)
	{
		for(int j = 0; j < 2; j++)
			cout << data[i][j] << ":";
		cout << endl;
	}
	*/
	
	return 0;
}