#include <bits/stdc++.h>
using namespace std;

char changeCase(char c)
{
	if(isupper(c))
		return tolower(c);
	return toupper(c);
}

int main()
{
	int n;
	string stemp;
	getline(cin, stemp);
	n = stoi(stemp);

	string data[n];
	for(int i = 0; i < n; i++)
	{
		string temp;
		getline(cin, temp);
		transform(temp.begin(), temp.end(), temp.begin(), changeCase);
		data[i] = temp;
	}
	sort(data, data+n);
	
	for(string i : data)
	{
		transform(i.begin(), i.end(), i.begin(), changeCase);
		cout << i << endl;
	}
	
	return 0;
}