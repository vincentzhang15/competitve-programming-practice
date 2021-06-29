#include <bits/stdc++.h>
using namespace std;

int main()
{
	int b, p;
	char v;
	cin >> b >> p >> v;
	
	if(p*5 <= b)
		cout << ((v == 'Y')?("B"):("A")) << endl;
	else if(p*2 <= b)
		cout << ((v == 'Y')?("D"):("C")) << endl;
	else
		cout << "NO PIZZA" << endl;
	
	return 0;
}