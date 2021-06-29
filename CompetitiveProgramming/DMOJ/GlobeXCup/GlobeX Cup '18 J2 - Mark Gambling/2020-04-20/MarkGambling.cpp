#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	int data [n];
	int sum = 0;
	for(int i = 0; i < n; i++)
	{
		cin >> data[i];
		sum += data[i];
	}
	
	double average = (double)sum/n;
	int count = 0;
	for(int i = 0; i < n; i++)
	{
		if(data[i] > average)
			count++;
	}
	
	double temp = (double)count/n*100.0;
	
	if(temp > 50)
		cout << "Winnie should take the risk" << endl;
	else
		cout << "That's too risky" << endl;
	
	return 0;
}