#include<bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);

	int n; cin >> n;
	int limits[n];
	
	for(int i = 0; i < n; i++)
		cin >> limits[i];

	cin.ignore(256, '\n');
	string line;
	getline(cin, line);
	line += " ";

	int first = 0;
	int last = 0;

	for(int i = 0; first < line.length(); i++)
	{
		int limit = limits[i%n];
		last = first + limit;
		last = line.find_last_of(' ', last);
		
		if(last < first)
		{
			cout << (line.substr(first, limit)) << endl;
			first += limit;
		}
		else
		{
			cout << (line.substr(first, last-first)) << endl;
			first = last + 1;
		}
	}
	
	return 0;
}