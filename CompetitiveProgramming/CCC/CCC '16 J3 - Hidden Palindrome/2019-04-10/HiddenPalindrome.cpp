#include <iostream>
using namespace std;

bool isPalindrome(string s)
{
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] != s[s.length()-1-i])
			return false;
	}
	return true;
}

int main()
{
	string s;
	cin >> s;
	
	string removeLeft = s;
	string removeRight = s;
	
	int longest = 0;
	
	for(int i = 0; i < s.length(); i++)
	{
		for(int j = s.length(); j > 0; j--)
		{
			string word = s.substr(i, j);
			if(isPalindrome(word))
				if(word.length() > longest)
					longest = word.length();
		}
	}
	
	cout << longest << endl;

	return 0;
}