#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	vector<int> a;
	vector<int> b;
	
	for(int i = 0; i < n; i++)
	{
		char c;
		int num;
		cin >> c >> num;
		
		if(c == 'F')
			a.push_back(num);
		else if(c == 'E')
			b.push_back(num);
		else
		{
			if(find(a.begin(), a.end(), num) != a.end())
				a.erase(remove(a.begin(), a.end(), num), a.end());
			else
				b.erase(remove(b.begin(), b.end(), num), b.end());
		}
	}
	
	for(vector<int>::reverse_iterator it = a.rbegin(); it != a.rend(); it++)
		cout << *it << endl;
	for(vector<int>::iterator it = b.begin(); it != b.end(); it++)
		cout << *it << endl;
	
	return 0;
}