#include <iostream>
#include <map>
using namespace std;

int main()
{
	string k, v, code;
	getline(cin, k);
	getline(cin, v);
	getline(cin, code);
	
	map<char, char> dictionary;
	for(int i = 0; i < k.length(); i++)
	{
		dictionary[v[i]] = k[i];
	}
	
	for(int i = 0; i < code.length(); i++)
	{
		if(dictionary.find(code[i]) == dictionary.end())
			cout << ".";
		else
			cout << dictionary.find(code[i])->second;
	}
	cout << endl;
	
	/*
	map<char, char>::iterator itr;
	for(itr = dictionary.begin(); itr != dictionary.end(); itr++)
	{
		cout << itr->first << ":" << itr->second << endl;
	}*/
	
	return 0;
}