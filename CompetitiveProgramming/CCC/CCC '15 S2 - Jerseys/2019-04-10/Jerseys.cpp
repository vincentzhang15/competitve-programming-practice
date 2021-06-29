#include <iostream>
using namespace std;

int main()
{
	int sizes, athletes;
	scanf("%d%d", &sizes, &athletes);
	//cout << sizes << ":" << athletes << endl;
	int s [sizes];

	for(int i = 1; i <= sizes; i++)
	{
		char c;
		scanf(" %c", &c);
		if(c == 'S')
			s[i] = 1;
		else if(c == 'M')
			s[i] = 2;
		else if(c == 'L')
			s[i] = 3;
	//cout << i << ":" << sizes << ":" << athletes << endl;
	}
	
	int count = 0;
	//cout << sizes << ":" << athletes << endl;
	for(int i = 1; i <= athletes; i++)
	{
		int r;
		char c;
		scanf(" %c%d", &c, &r);
		int l;

		if(c == 'S')
			l = 1;
		else if(c == 'M')
			l = 2;
		else if(c == 'L')
			l = 3;
		
		if(1 <= r && r <= sizes && s[r] >= l)
		{
			s[r] = -1;
			count++;
		}
	}
	cout << count << endl;

	return 0;
}