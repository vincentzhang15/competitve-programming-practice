#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<string> data;

void split(string s)
{
	string temp = "";
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == ' ')
		{
			data.push_back(temp);
			temp = "";
		}
		else
			temp += s[i];
	}
}

int main()
{
	int n;
	cin >> n;
	
	vector<string> dictionary;
	for(int i = 0; i < n; i++)
	{
		string word;
		cin >> word;
		dictionary.push_back(word);
	}
	
	string sentence;
	getline(cin, sentence);
	getline(cin, sentence);
	sentence += " ";
	split(sentence);
	
	// PRINT START
/*	cout << "-------------------" << endl;
	cout << n << ":" << sentence << endl;
	for(string s : dictionary)
		cout << "[" << s << "]" << endl;
	cout << "-------------------" << endl;
*/	// PRINT END
	
	for(string s : data)
	{
		//cout << "(" << s << ")" << endl;
		if(find(dictionary.begin(), dictionary.end(), s) == dictionary.end())
		{
			printf("Incorrect");
			return 0;
		}
	}
	printf("Correct");
	
	return 0;
}