#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		string newStr = "";
		for(int j = 0; j < s.length(); j++)
		{
			if(s[j] >= '0' && s[j] <= '9')
				newStr += s[j];
			else if(s[j] >= 'A' && s[j] <= 'Z')
			{
				switch(s[j])
				{
					case 'A': case 'B': case 'C': newStr += "2"; break;
					case 'D': case 'E': case 'F': newStr += "3"; break;
					case 'G': case 'H': case 'I': newStr += "4"; break;
					case 'J': case 'K': case 'L': newStr += "5"; break;
					case 'M': case 'N': case 'O': newStr += "6"; break;
					case 'P': case 'Q': case 'R': case 'S': newStr += "7"; break;
					case 'T': case 'U': case 'V': newStr += "8"; break;
					case 'W': case 'X': case 'Y': case 'Z': newStr += "9"; break;
				}
			}
		}
		cout << newStr[0] << newStr[1] << newStr[2] << "-" << newStr[3] << newStr[4] << newStr[5] << "-" << newStr[6] << newStr[7] << newStr[8] << newStr[9] << endl;
	}
	
	return 0;
}