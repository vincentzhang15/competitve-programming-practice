#include <bits/stdc++.h>
using namespace std;

int main()
{
	string n;
	getline(cin, n);
	
	//setlocale(LC_ALL, "de_DE.iso88591");
    std::setlocale(LC_ALL, "de_DE.UTF-8");
	
	string s;
	while(getline(cin, s))
	{
		int start = -1;
		int i = 0;
		for(string::iterator it = s.begin(); it != s.end(); it++)
		{
			if(isupper(*it))
			{
				start = i;
			}
			
			if(start != -1 && !isalpha(*it))
			{
				cout << (s.substr(start, i-start)) << endl;
				start = -1;
			}
			else if((start != -1) && (i == s.length()-1))
				cout << (s.substr(start)) << endl;
			
			

/*


			if(isalpha(*it))
			{
				str += *it;
				cout << *it;
			}
			else
			{
				if(isupper(s[0]))
					cout << str << endl;
				str = "";
			}*/
			i++;
		}
	}
	
	return 0;
}