#include <bits/stdc++.h>
using namespace std;

int main()
{
	char a [102];
	char b [100];
	char g [102];
	
	for(int i = 0; i < 102; i+=3)
	{
		a[i] = 'A';
		a[i+1] = 'B';
		a[i+2] = 'C';
	}
	for(int i = 0; i < 100; i+=4)
	{
		b[i] = 'B';
		b[i+1] = 'A';
		b[i+2] = 'B';
		b[i+3] = 'C';
	}
	for(int i = 0; i < 102; i+=6)
	{
		g[i] = 'C';
		g[i+1] = 'C';
		g[i+2] = 'A';
		g[i+3] = 'A';
		g[i+4] = 'B';
		g[i+5] = 'B';
	}
	
	int n; cin >> n;
	string s; cin >> s;
	
	int ca = 0;
	int cb = 0;
	int cg = 0;
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == a[i]) ca++;
		if(s[i] == b[i]) cb++;
		if(s[i] == g[i]) cg++;
	}
	
	int maxx = max(max(ca, cb), cg);
	cout << maxx << endl;
	
	if(ca == maxx) cout << "Adrian" << endl;
	if(cb == maxx) cout << "Bruno" << endl;
	if(cg == maxx) cout << "Goran" << endl;
	
	return 0;
}