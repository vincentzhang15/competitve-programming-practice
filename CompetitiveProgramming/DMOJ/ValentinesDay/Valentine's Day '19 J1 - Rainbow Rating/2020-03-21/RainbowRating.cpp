#include <bits/stdc++.h>
using namespace std;

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		
		if(temp < 1000)
			cout << "Newbie\n";
		else if(temp >= 1000 && temp <= 1199)
			cout << "Amateur\n";
		else if(temp >= 1200 && temp <= 1499)
			cout << "Expert\n";
		else if(temp >= 1500 && temp <= 1799)
			cout << "Candidate Master\n";
		else if(temp >= 1800 && temp <= 2199)
			cout << "Master\n";
		else if(temp >= 2200 && temp <= 2999)
			cout << "Grandmaster\n";
		else if(temp >= 3000 && temp <= 3999)
			cout << "Target\n";
		else
			cout << "Rainbow Master\n";
	}
	
	return 0;
}