#include <bits/stdc++.h>
using namespace std;

int main()
{
	string temp;
	getline(cin, temp);
	int n = stoi(temp);
	string data [n];
	
	int loc = -1;
	for(int i = 0; i < n; i++)
	{
		getline(cin, data[i]);
		if(data[i].compare("Bessarion") == 0)
		{
			loc = i;
		}
	}
	
	if(loc >= 1 && loc != n-1)
	{
		if((data[loc-1].compare("Bayview") == 0 && data[loc+1].compare("Leslie") == 0) || (data[loc-1].compare("Leslie") == 0 && data[loc+1].compare("Bayview") == 0))
		{
			cout << "Y" << endl;
			return 0;
		}
	}
	cout << "N" << endl;
	
	return 0;
}