#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int data [n];
	for(int i = 0; i < n; i++)
		cin >> data[i];
	
	int x = 0;
	int f = 0;
	
	for(int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		if(data[i] > a)
			x++;
		else if(data[i] < a)
			f++;
	}
	
	cout << x << " " << f << endl;
	cout << (x>f?"Xyene":(x==f?"Tie":"FatalEagle")) << endl;
	
	return 0;
}