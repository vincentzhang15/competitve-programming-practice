#include <iostream>
using namespace std;

int main()
{
	int adj, n;
	cin >> adj >> n;
	
	string adjectives [adj];
	string nouns [n];
	
	for(int i = 0; i < adj; i++)
		cin >> adjectives[i];
	for(int i = 0; i < n; i++)
		cin >> nouns[i];
	
	for(int i = 0; i < adj; i++)
	{
		for(int j = 0; j < n; j++)
		{
			cout << adjectives[i] << " as " << nouns[j] << endl;
		}
	}
	
	return 0;
}