#include<iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int count = 0;
	
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n*2; j++)
		{
			if(j <= count || n*2-j-1 <= count)
				cout << "*";
			else
				cout << " ";
		}
		if(i >= n/2)
			count -= 2;
		else
			count += 2;
		cout << endl;
	}
	return 0;
}