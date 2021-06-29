#include<iostream>
using namespace std;

int main()
{
	string line1, line2;
	int k;
	
	getline(cin, line1);
	getline(cin, line2);
	cin >> k;
	
	int count = 0;
	for(int i = 0; i < line1.length(); i++)
	{
		if(line1[i] != line2[i])
			count++;
		if(count > k || line1[i] == ' ' && line2[i] != ' ' || line2[i] == ' ' && line1[i] != ' ')
		{
			cout << "No plagiarism" << endl;
			return 0;
		}
	}
	cout << "Plagiarized" << endl;
	
	return 0;
}