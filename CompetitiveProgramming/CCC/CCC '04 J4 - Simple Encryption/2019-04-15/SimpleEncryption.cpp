#include <iostream>
using namespace std;

int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
	
	string top, line;
	getline(cin, top);
	getline(cin, line);
	
	int shift[top.length()];
	for(int i = 0; i < top.length(); i++)
		shift[i] = top[i] - 'A';
	
	int mod = 0;
	for(int i = 0; i < line.length(); i++)
	{
		if(line[i] >= 'A' && line[i] <= 'Z')
		{
			int num = ((line[i] - 'A') + shift[mod])%26;
			//cout << (char)(num + 'A') << ":" << num << ":" << (line[i] - 'A') << ":" << shift[mod] << ":" << mod <<":" << top.length() << endl;
			cout << (char)(num + 'A');

			mod++;
			if(mod == top.length()-1)
				mod = 0;
		}
	}
	cout << endl;
	
	return 0;
}