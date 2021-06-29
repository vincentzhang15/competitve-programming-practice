#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	string correct [n];
	for(int i = 0; i < n; i++)
		cin >> correct[i];
	string answer [n];
	for(int i = 0; i < n; i++)
		cin >> answer[i];
	
	int count = 0;
	for(int i = 0; i < n; i++)
		if(correct[i] == answer[i])
			count ++;
		
	cout << count << endl;
	
	return 0;
}