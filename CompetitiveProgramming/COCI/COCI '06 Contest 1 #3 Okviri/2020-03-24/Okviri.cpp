#include <bits/stdc++.h>
using namespace std;

string s;
int n;

void one()
{
	string str = "..";
	for(int j = 1; j < n; j++)
	{
		if(j%3 == 0)
			str += "*...";
		else
			str += "#...";
	}
	if(n%3 == 0)
		str += "*";
	else
		str += "#";
	
	str += "..";
	
	cout << str << endl;
}

void two()
{
	string str = ".";
	for(int j = 1; j <= n; j++)
	{
		if(j%3 == 0)
			str += "*.*.";
		else
			str += "#.#.";
	}
	
	cout << str << endl;
}

void three()
{
	string str = "";
	for(int i = 0; i < n; i++)
	{
		string temp (1, s[i]);
		if(((i+1) % 3 == 0 || (i+1) % 3 == 1) && i != 0)
			str += "*." + temp + ".";
		else
			str += "#." + temp + ".";
	}
	if(n%3 == 0)
		str += "*";
	else
		str += "#";
	
	cout << str << endl;
}

int main()
{
	cin >> s;
	
	n = s.length();
	
	if(n == 1)
	{
		cout << "..#.." << endl;
		cout << ".#.#." << endl;
		cout << "#." << s << ".#" << endl;
		cout << ".#.#." << endl;
		cout << "..#.." << endl;
		return 0;
	}
	
	one();
	two();
	three();
	two();
	one();
	
	return 0;
}