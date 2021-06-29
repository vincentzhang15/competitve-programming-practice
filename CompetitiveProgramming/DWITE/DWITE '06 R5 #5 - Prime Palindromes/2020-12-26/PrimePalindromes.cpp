#include <bits/stdc++.h>
using namespace std;

bool isP[1000000];

bool p(int i)
{
	string s = to_string(i);
	string r = s;
	reverse(r.begin(), r.end());
	if(s.compare(r) != 0)
		return false;
	return true;
}

void sieveP()
{
	memset(isP, true, sizeof isP);
	for(int i = 2; i < 1000000; i++)
		if(isP[i])
		{
			for(int j = i*2; j < 1000000; j+=i)
				isP[j] = false;
			if(!p(i))
				isP[i] = false;
		}
}

int main()
{
	sieveP();
	cin.sync_with_stdio(0);
	cin.tie(0);
	for(int i = 0; i < 5; i++)
	{
		int a, b;
		cin >> a >> b;
		int count = 0;
		for(int j = a; j <= b; j++)
			if(isP[j])
				count++;
		cout << count << endl;
	}
	
	return 0;
}