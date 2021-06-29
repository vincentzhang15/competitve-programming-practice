#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
using namespace std;

int main()
{
	for(int i = 0; i < 10; i++)
	{
		int t, a, p, q, n;
		scan(t);
		scan(a);
		scan(p);
		scan(q);
		scan(n);
		
		int count = 0;
		for(int j = 0; j < n; j++)
		{
			int m1, m2, m3, m4;
			scan(m1);
			scan(m2);
			scan(m3);
			scan(m4);
			double mark = (m1*t + m2*a + m3*p + m4*q)/100.0;
			
			if((int)mark >= 50)
				count++;
		}
		printf("%d\n", count);
	}
	
	return 0;
}