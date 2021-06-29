#include <iostream>
#include <cstring>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int j = 0; j < n; j++)
	{
		string s;
		cin >> s;
		s += ' ';
		
		int count = 1;
		for(int i = 0; i < strlen(s.c_str()); i++)
		{
			//cout << endl << "------------------------------- " << i << ":" << endl;
			char last;
			if(i == 0)
			{
				last = s[0];
			}
			else
			{
				last = s[i-1];
				if(last != s[i])
				{
					cout << count << " " << last << " ";
					count = 1;
				}
				else
					count++;
			}
		}
		cout << endl;
	}
	
	return 0;
}