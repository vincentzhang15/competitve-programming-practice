#include <iostream>
using namespace std;

int main()
{
	string s1, s2;
	int n;
	
	getline(cin, s1);
	getline(cin, s2);
	cin >> n;
	
	int count = 0;
	for(int i = 0; i < s1.length(); i++)
	{
		if(s1[i] == ' ' && s2[i] != ' ' || s1[i] != ' ' && s2[i] == ' ')
		{
			cout << "No plagiarism" << endl;
			return 0;
		}
		if(s1[i] != s2[i])
			count++;
	}
	
	if(count <= n)
		cout << "Plagiarized" << endl;
	else
		cout << "No plagiarism" << endl;
	
	return 0;
}