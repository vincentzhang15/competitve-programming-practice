#include <bits/stdc++.h>
using namespace std;

int main()
{
	string data [11];
	string s = " ";
	
	int i;
	for(i = 0; i < 11; i++)
	{
		cin >> s;
		if(s.compare("SCHOOL") == 0)
			break;
		
		data[i] = s;
	}
	
	for(int j = i-1; j >= 0; j--)
	{
		if(data[j].compare("R") == 0)
			cout << "Turn LEFT";
		else if(data[j].compare("L") == 0)
			cout << "Turn RIGHT";
		else
			cout << " onto " << data[j] << " street." << endl;
	}
	
	cout << " into your HOME." << endl;
		
	return 0;
}