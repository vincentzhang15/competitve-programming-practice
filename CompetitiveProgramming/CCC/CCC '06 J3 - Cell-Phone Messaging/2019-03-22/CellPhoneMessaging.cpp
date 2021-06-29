#include<iostream>
using namespace std;

int main()
{
	string line;
	while(1)
	{
		cin >> line;
		if(line == "halt")
			return 0;
		
		int count = 0;
		for(int i = 0; i < line.length(); i++)
		{
			int c = 4;
			if(line[i] == 'a' || line[i] == 'd' || line[i] == 'g' || line[i] == 'j' || line[i] == 'm' || line[i] == 'p' || line[i] == 't' || line[i] == 'w')
				c = 1;
			else if(line[i] == 'b' || line[i] == 'e' || line[i] == 'h' || line[i] == 'k' || line[i] == 'n' || line[i] == 'q' || line[i] == 'u' || line[i] == 'x')
				c = 2;
			else if(line[i] == 'c' || line[i] == 'f' || line[i] == 'i' || line[i] == 'l' || line[i] == 'o' || line[i] == 'r' || line[i] == 'v' || line[i] == 'y')
				c = 3;
			else
				c = 4;
			
			count +=c;
			
			//cout << count << "---1----" << line << endl;
			int last = i-1;
			if(last >= 0)
			{	
				if(line[last] >= line[i]-c+1 && line[last] <= line[i]-c+4)
				{
					char s = line[i]-c+1;
					if(s == 'p' || s == 'w')
						count += 2;
					else if(line[last] <= line[i]-c+3)
						count += 2;
				}
			}
			//cout << count << "---2----" << endl;
		}
		cout << count << endl;
	}
	
	return 0;
}