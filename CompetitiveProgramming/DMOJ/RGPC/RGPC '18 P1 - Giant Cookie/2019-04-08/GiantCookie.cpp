#include <iostream>
using namespace std;

int main()
{
	int pieces, people;
	cin >> pieces >> people;
	
	if(pieces % people == 0)
		cout << "yes " << pieces/people << endl;
	else
	{
		for(int i = people;; i++)
		{
			if(pieces % i == 0)
			{
				cout << "no " << i-people << endl;
				return 0;
			}
		}
	}
	
	return 0;
}