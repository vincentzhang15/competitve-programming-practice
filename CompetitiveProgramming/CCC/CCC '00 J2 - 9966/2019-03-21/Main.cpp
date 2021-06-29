#include <iostream>
using namespace std;

bool flippable (int j)
{
	string num = to_string(j);
	for(int i = 0; i < num.length(); i++)
	{
		switch (num[i])
		{
			case '1': if(num[num.length()-1-i] != '1') return false; break;
			case '8': if(num[num.length()-1-i] != '8') return false; break;
			case '0': if(num[num.length()-1-i] != '0') return false; break;
			case '6': if(num[num.length()-1-i] != '9') return false; break;
			case '9': if(num[num.length()-1-i] != '6') return false; break;
			default: return false;
		}
	}
	return true;
}

int main()
{
	int lower, higher;
	cin >> lower >> higher;
	
	int count = 0;
	for(int i = lower; i <= higher; i++)
		if(flippable(i))
			count++;
	cout << count;
	
	return 0;
}