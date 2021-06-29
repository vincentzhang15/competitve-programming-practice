#include <algorithm>
#include <cstdio>
#include <cstring>
#include <bits/stdc++.h>

using namespace std;

typedef long long llint;

llint A, B;
llint p10[16];
llint memo[16][11];

llint intersect( int n, llint prefix ) {
   if( n < 0 ) return 0;
   llint lo = max( prefix * p10[n], A );
   llint hi = min( (prefix+1) * p10[n] - 1, B );
   if( lo > hi ) return 0;
   cout << "intersect(" << n << "," << prefix << ") = " << (hi-lo+1) << endl;
   return hi-lo+1;
}

llint rec( int n, int prev, llint prefix ) {
	cout << "=============== n: " << n << "\tprev:" << prev << "\tprefix: " << prefix << " ================" << endl;
   llint mini = prefix * p10[n];
   llint maxi = (prefix+1) * p10[n] - 1;
   
   cout << "MIN: " << mini << "\tMAX: " << maxi << endl;
   

   if( mini > B || maxi < A )
   {
	   cout << "\treturn 0" << endl;
	   return 0;
   }
   if( mini >= A && maxi <= B && memo[n][prev] != -1 )
   {
	   cout << "\treturn memo[n][prev]" << endl;
	   return memo[n][prev];
   }

   llint ret = 0;
   for( int digit = 0; digit <= 9; ++digit ) {
	   cout << "digit: " << digit << endl;
      if( digit == prev )
	  {
		  cout << "\tcontinue" << endl;
		  continue;
	  }
      
      llint t = prefix;
	  cout << "t=prefix: " << t << endl;
      for( int k = 1; k <= n; ++k ) {
         t = t*10+digit;
		  cout << "t = t*10+digit: " << t << endl;
         cout << "digit: " << digit << " k: " << k << " intersect(" << (n-k) << "," << t << ") - intersect(" << (n-k-1) << "," << (t*10+digit) << ") + rec(" << (n-k) << "," << digit << "," << t << ")" << endl;
         ret += digit * k * k * (intersect( n-k, t )-intersect( n-k-1, t*10+digit)) + rec( n-k, digit, t );
		 cout << "ret: " << ret << endl;
      }
   }

   if( mini >= A && maxi <= B ) memo[n][prev] = ret;

   return ret;
}

int main( void ) {
   scanf( "%lld%lld", &A, &B );
   cout << "-------------------" << endl;
   cout << "A: " << A << "\tB:" << B << endl;
   cout << "-------------------" << endl << endl;

   p10[0] = 1;
   for( int i = 1; i <= 15; ++i ) p10[i] = p10[i-1] * 10;

   memset( memo, -1, sizeof memo );
   printf( "%lld\n", rec( 15, 10, 0 ) );
   
   /*
   for(int i = 0; i < 16; i++)
   {
	   for(int j = 0; j < 11; j++)
	   {
		   cout << memo[i][j] << " ";
		   
	   }
	   cout << endl;
   }
   */

   return 0;
}


/*
#include <bits/stdc++.h>
using namespace std;

long long calc(string s)
{
	s += " ";
	long long n = 0;
	char lastChar = s[0];
	int count = 1;
	for(int i = 1; i < s.length(); i++)
	{
		char c = s[i];
		if(c != lastChar)
		{
			n += (int)(lastChar-'0')*count*count;
			
			if(c == ' ')
				break;
			else
			{
				lastChar = c;
				count = 1;
			}
		}
		else
			count++;
	}
	
	return n;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	long long a, b;
	cin >> a >> b;
	
	long long sum = 0;
	for(long long i = a; i <= b; i++)
	{
		sum += calc(to_string(i));
	}
	
	cout << sum << endl;
	
	return 0;
}
*/