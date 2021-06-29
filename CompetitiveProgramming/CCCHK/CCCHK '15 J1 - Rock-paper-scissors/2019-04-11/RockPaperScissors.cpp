#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int a = 0;
	int b = 0;
	
	string data[n];
	for(int i = 0; i < n; i++)
		cin >> data[i];
	for(int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		
		if(s == "rock" && data[i] == "paper")
			a++;
		else if(s == "rock" && data[i] == "scissors")
			b++;
		else if(s == "paper" && data[i] == "scissors")
			a++;
		else if(s == "paper" && data[i] == "rock")
			b++;
		else if(s == "scissors" && data[i] == "rock")
			a++;
		else if(s == "scissors" && data[i] == "paper")
			b++;
	}
	
	cout << a << " " << b << endl;
	
	return 0;
}