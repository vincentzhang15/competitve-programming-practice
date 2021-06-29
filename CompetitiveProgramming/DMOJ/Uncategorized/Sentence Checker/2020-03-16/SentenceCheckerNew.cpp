#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	vector<string> data;
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		data.push_back(s);
	}
	
	string s;
	while(cin >> s)
	{
		bool found = false;
		for(vector<string>::iterator it = data.begin(); it != data.end(); it++)
		{
			string str = it->c_str();
			if(str.compare(s) == 0)
				found = true;
		}
		
		if(!found)
		{
			cout << "Incorrect" << endl;
			return 0;
		}
	}
	
	cout << "Correct" << endl;
	
	return 0;
}