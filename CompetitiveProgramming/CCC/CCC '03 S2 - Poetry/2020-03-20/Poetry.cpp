#include<bits/stdc++.h>
using namespace std;

string toLower(string str)
{
	for(int i = 0; i < str.length(); i++)
		if(str[i] >= 'A' && str[i] <= 'Z')
			str[i] = str[i]-'A'+'a';
	return str;
}

string split(string s)
{
	string str = "";
	int i = (s[s.length()-1] == '\n' || s[s.length()-1] == '\r')?(s.length()-2):(s.length()-1);
	for(i; i >= 0; i--)
	{
		str += s[i];
		if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == ' '
		|| s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U')
			break;
	}

	reverse(str.begin(), str.end());
	//cout << str << endl;
	
	return toLower(str);
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	string ss;
	getline(cin, ss);
	int n = stoi(ss);
	
	for(int i = 0; i < n; i++)
	{
		string data [4];
		getline(cin, data[0]);
		getline(cin, data[1]);
		getline(cin, data[2]);
		getline(cin, data[3]);
		
		//for(int j = 0; j < 4; j++)
			//cout << data[j] << ":" << endl;

		string one = split(data[0]);
		string two = split(data[1]);
		string three = split(data[2]);
		string four = split(data[3]);
		
		//cout << one.compare(three) << ":" << two.compare(four) << ":" << two.compare(three) << endl;
		if(one.compare(two) == 0 && two.compare(three) == 0 && three.compare(four) == 0)
			cout << "perfect" << "\n";
		else if(one.compare(two) == 0 && two.compare(three) != 0 && three.compare(four) == 0)
			cout << "even" << "\n";
		else if(one.compare(three) == 0 && two.compare(three) != 0 && two.compare(four) == 0)
			cout << "cross" << "\n";
		else if(one.compare(four) == 0 && two.compare(three) == 0 && one.compare(two) != 0)
			cout << "shell" << "\n";
		else
			cout << "free" << "\n";
	}
	
	return 0;
}