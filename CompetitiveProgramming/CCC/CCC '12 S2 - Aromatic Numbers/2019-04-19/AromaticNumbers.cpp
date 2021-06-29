#include <iostream>
using namespace std;

int main()
{
	string s;
	getline(cin, s);
	
	int data[s.length()/2];
	int a[s.length()/2];
	int b[s.length()/2];
	int sum = 0;
	
	for(int i = 0; i < s.length(); i+=2)
	{
		a[i/2] = s[i] - '0';
		switch(s[i+1])
		{
			case 'I': b[i/2] = 1; break;
			case 'V': b[i/2] = 5; break;
			case 'X': b[i/2] = 10; break;
			case 'L': b[i/2] = 50; break;
			case 'C': b[i/2] = 100; break;
			case 'D': b[i/2] = 500; break;
			case 'M': b[i/2] = 1000; break;
		}
	}
	
	for(int i = 0; i < s.length()/2; i++)
		sum += a[i]*b[i];
	
	for(int i = 0; i < s.length()/2-1; i++)
	{
		if(b[i+1] > b[i])
			sum -= 2*a[i]*b[i];
	}
	cout << sum << endl;

	return 0;
}