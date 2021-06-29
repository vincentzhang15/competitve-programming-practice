#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	int max = -INT_MAX;
	for(int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		
		if(temp > max)
			max = temp;
	}
	
	if(max > 10000)
		cout << "Something is wrong with these cuteness values" << endl;
	else if(max > 1000)
		cout << "Cuteness by definition is similarity to Cactus" << endl;
	else
		cout << "Cuteness by definition is similarity to Carol" << endl;
	
	return 0;
}