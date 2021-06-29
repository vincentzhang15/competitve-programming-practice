#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		if(a == 0)
		{
			cout << "Weekend" << endl;
			continue;
		}
		
		int count = 0;
		for(int i = 0; i < a; i++)
		{
			int b;
			cin >> b;
			count += b;
		}
		cout << "Day " << (i+1) << ": " << count << endl;
	}
	
	return 0;
}