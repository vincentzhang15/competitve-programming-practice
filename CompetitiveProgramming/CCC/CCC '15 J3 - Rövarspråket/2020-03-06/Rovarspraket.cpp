#include <bits/stdc++.h>
using namespace std;

bool isVowel(char c)
{
	string s = "aeiou";
	for(int i = 0; i < s.length(); i++)
		if(s[i] == c)
			return true;
	
	return false;
}

char closestVowel(char c)
{
	int a = abs(c-'a');
	int e = abs(c-'e');
	int i = abs(c-'i');
	int o = abs(c-'o');
	int u = abs(c-'u');
	
	int diff = min(min(min(min(a, e), i), o), u);
	
	return ((isVowel(c-diff))?(c-diff):(c+diff));
}

char nextConsonant(char c)
{
	if(c == 'z')
		return 'z';
	if(isVowel(c+1))
		return (c+2);
	else
		return (c+1);
}

int main()
{
	string s;
	cin >> s;
	
	for(int i = 0; i < s.length(); i++)
	{
		if(isVowel(s[i]))
			cout << s[i];
		else
			cout << s[i] << closestVowel(s[i]) << nextConsonant(s[i]);
	}
	
	return 0;
}