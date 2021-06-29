#include <bits/stdc++.h>
using namespace std;

int main()
{
	int a = 0;
	int b = 0;
	while(true)
	{
		int n;
		cin >> n;
		
		if(n == 1)
		{
			char c0;
			int x;
			cin >> c0 >> x;
			if(c0 == 'A')
				a = x;
			else
				b = x;
		}
		else if(n == 2)
		{
			char c;
			cin >> c;
			if(c == 'A')
				cout << a << endl;
			else
				cout << b << endl;
		}
		else if(n == 3)
		{
			char c1;
			char c2;
			cin >> c1 >> c2;
			if(c1 == 'A' && c2 == 'A')
				a = a+a;
			else if(c1 == 'A' && c2 == 'B')
				a = a+b;
			else if(c1 == 'B' && c2 == 'A')
				b = b+a;
			else if(c1 == 'B' && c2 == 'B')
				b = b+b;
		}
		else if(n == 4)
		{
			char c1;
			char c2;
			cin >> c1 >> c2;
			if(c1 == 'A' && c2 == 'A')
				a = a*a;
			else if(c1 == 'A' && c2 == 'B')
				a = a*b;
			else if(c1 == 'B' && c2 == 'A')
				b = b*a;
			else if(c1 == 'B' && c2 == 'B')
				b = b*b;
		}
		else if(n == 5)
		{
			char c1;
			char c2;
			cin >> c1 >> c2;
			if(c1 == 'A' && c2 == 'A')
				a = a-a;
			else if(c1 == 'A' && c2 == 'B')
				a = a-b;
			else if(c1 == 'B' && c2 == 'A')
				b = b-a;
			else if(c1 == 'B' && c2 == 'B')
				b = b-b;
		}
		else if(n == 6)
		{
			char c1;
			char c2;
			cin >> c1 >> c2;
			if(c1 == 'A' && c2 == 'A')
				a = a/a;
			else if(c1 == 'A' && c2 == 'B')
				a = a/b;
			else if(c1 == 'B' && c2 == 'A')
				b = b/a;
			else if(c1 == 'B' && c2 == 'B')
				b = b/b;
		}
		else
			return 0;
	}
	
	return 0;
}