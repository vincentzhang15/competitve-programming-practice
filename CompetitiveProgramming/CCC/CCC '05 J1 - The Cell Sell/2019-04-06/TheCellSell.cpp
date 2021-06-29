#include <iostream>
using namespace std;

int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	
	double planA = (a-100<0?0:a-100)*25 + b*15 + c*20;
	double planB = (a-250<0?0:a-250)*45 + b*35 + c*25;
	
	cout << "Plan A costs " << planA/100.0 << endl;
	cout << "Plan B costs " << planB/100.0 << endl;
	
	if(planA < planB)
		cout << "Plan A is cheapest." << endl;
	else if(planA == planB)
		cout << "Plan A and B are the same price." << endl;
	else
		cout << "Plan B is cheapest." << endl;
	
	return 0;
}