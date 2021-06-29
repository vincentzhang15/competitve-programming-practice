#include<iostream>
using namespace std;

int main()
{
	char data [4];
	cin >> data[0] >> data[1] >> data[2] >> data[3];
	
	string s1 = "";
	string s2 = "";
	
	bool l = false;
	bool r = false;
	for(int i = 0; i < 4; i++)
	{
		if(!l && data[i] == 'L')
		{
			s1 += to_string(i+1) + " ";
			l = !l;
		}
		else if(l && data[i] == 'L')
		{
			s2 += to_string(i+1) + " ";
			l = !l;
		}

		if(!r && data[i] == 'R')
		{
			s1 += to_string(i+1) + " ";
			r = !r;
		}
		else if(r && data[i] == 'R')
		{
			s2 += to_string(i+1) + " ";
			r = !r;
		}
	}
	
	cout << s1 << endl;
	cout << s2 << endl;
	
	return 0;
}