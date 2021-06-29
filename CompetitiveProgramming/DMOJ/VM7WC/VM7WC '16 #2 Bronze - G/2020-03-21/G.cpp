#include <bits/stdc++.h>
using namespace std;

void print(int n, string s)
{
	string str = "";
	for(int i = 0; i < s.length(); i++)
	{
		for(int j = 0; j < n; j++)
		{
			str += s[i];
		}
	}
	for(int i = 0; i < n; i++)
		printf("%s\n", str.c_str());
}

int main()
{
	int n;
	scanf("%d", &n);
	
	print(n, "GGGGG");
	print(n, "G....");
	print(n, "G..GG");
	print(n, "G...G");
	print(n, "GGGGG");
	
	return 0;
}