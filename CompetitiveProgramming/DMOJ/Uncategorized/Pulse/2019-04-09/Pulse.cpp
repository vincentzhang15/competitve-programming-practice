#include <iostream>
using namespace std;

int main()
{
	int n, s, t;
	cin >> n >> s >> t;
	
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		if(num*2 >= s && num*2 <= t)
			count++;
	}
	cout << count << endl;
	
	return 0;
}