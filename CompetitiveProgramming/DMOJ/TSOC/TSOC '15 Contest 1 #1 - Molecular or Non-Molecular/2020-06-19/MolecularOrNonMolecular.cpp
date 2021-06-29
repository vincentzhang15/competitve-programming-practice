#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	set<string> data;
	data.insert("Cl");
	data.insert("Br");
	data.insert("Xe");
	data.insert("Kr");
	data.insert("Si");
	data.insert("As");
	data.insert("Rn");
	data.insert("Ne");
	data.insert("He");
	data.insert("H");
	data.insert("C");
	data.insert("N");
	data.insert("O");
	data.insert("F");
	data.insert("P");
	data.insert("S");
	data.insert("I");
	
	string n;
	getline(cin, n);
	
	while(getline(cin, n))
	{
		bool broke = false;
		string element = "";
		for(int i = 0; i < n.length(); i++)
		{
			if((n[i] >= 'a' && n[i] <= 'z') || (n[i] >= 'A' && n[i] <= 'Z'))
				element += n[i];
			else
			{
				if(data.find(element) == data.end())
				{
					cout << "Not molecular!" << endl;
					broke = true;
					break;
				}
				element = "";
			}
		}
		if(!broke)
			cout << "Molecular!" << endl;
	}
	
	return 0;
}