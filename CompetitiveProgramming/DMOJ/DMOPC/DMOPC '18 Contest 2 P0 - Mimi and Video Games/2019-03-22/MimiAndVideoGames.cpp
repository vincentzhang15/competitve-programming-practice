#include<iostream>
using namespace std;

int main()
{
	int N, a, R;
	cin >> N >> a >> R;
	
	int first = (int)((double)R/a);
	if(first < N)
		cout << first;
	else
		cout << N;
	
	return 0;
}