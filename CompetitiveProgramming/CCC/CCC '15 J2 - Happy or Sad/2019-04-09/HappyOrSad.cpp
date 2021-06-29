#include <iostream>
using namespace std;

int main()
{
	string s;
	getline(cin, s);
	
	int happy = 0;
	string strHappy = s;
	while(true)
	{
		if(strHappy.find(":-)") == -1)
			break;
		else
		{
			happy++;
			strHappy = strHappy.substr(strHappy.find(":-)") + 3);
		}
	}

	int sad = 0;
	string strSad = s;
	while(true)
	{
		if(strSad.find(":-(") == -1)
			break;
		else
		{
			sad++;
			strSad = strSad.substr(strSad.find(":-(") + 3);
		}
	}
	
	if(happy > sad)
		cout << "happy" << endl;
	else if(sad > happy)
		cout << "sad" << endl;
	else if(sad == happy && sad != 0)
		cout << "unsure" << endl;
	else
		cout << "none" << endl;
	
	return 0;
}