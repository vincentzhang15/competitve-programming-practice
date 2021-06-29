#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin. tie(0);
	
	int n;
	cin >> n;
	char c;
	while(cin.get(c))
	{
		if(isupper(c))
			cout << (char)(((int)(c-'A')-n+26000)%26+'A');
		if(islower(c))
			cout << (char)(((int)(c-'a')-n+26000)%26+'a');
		if(c == ' ')
			cout << " ";
	}
	cout << endl;
	
	return 0;
}