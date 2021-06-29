#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	string data [n];
	
	for(int i = 0; i < n; i++)
		cin >> data[i];
	
	string word;
	cin >> word;
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		if(word.length() == data[i].length())
		{
			for(int j = 0; j < word.length(); j++)
			{
				char number = word[j];
				bool correct = false;
				switch(number)
				{
					case '2':
						if(data[i][j] == 'a' || data[i][j] == 'b' || data[i][j] == 'c')
							correct = true;
						break;
					case '3':
						if(data[i][j] == 'd' || data[i][j] == 'e' || data[i][j] == 'f')
							correct = true;
						break;
					case '4':
						if(data[i][j] == 'g' || data[i][j] == 'h' || data[i][j] == 'i')
							correct = true;
						break;
					case '5':
						if(data[i][j] == 'j' || data[i][j] == 'k' || data[i][j] == 'l')
							correct = true;
						break;
					case '6':
						if(data[i][j] == 'm' || data[i][j] == 'n' || data[i][j] == 'o')
							correct = true;
						break;
					case '7':
						if(data[i][j] == 'p' || data[i][j] == 'q' || data[i][j] == 'r' || data[i][j] == 's')
							correct = true;
						break;
					case '8':
						if(data[i][j] == 't' || data[i][j] == 'u' || data[i][j] == 'v')
							correct = true;
						break;
					case '9':
						if(data[i][j] == 'w' || data[i][j] == 'x' || data[i][j] == 'y' || data[i][j] == 'z')
							correct = true;
						break;
				}
				
				if(!correct)
					break;
				if(j == word.length()-1)
					count++;
			}
		}
	}
	cout << count << endl;
	
	return 0;
}