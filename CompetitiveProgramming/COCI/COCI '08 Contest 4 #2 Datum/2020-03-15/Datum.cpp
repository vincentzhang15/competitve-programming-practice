#include <bits/stdc++.h>
using namespace std;

int main()
{
	int d, m;
	cin >> d >> m;
	
	switch(m)
	{
		case 1: case 10:
			if(d%7 == 0) cout << "Wednesday" << endl;
			if(d%7 == 1) cout << "Thursday" << endl;
			if(d%7 == 2) cout << "Friday" << endl;
			if(d%7 == 3) cout << "Saturday" << endl;
			if(d%7 == 4) cout << "Sunday" << endl;
			if(d%7 == 5) cout << "Monday" << endl;
			if(d%7 == 6) cout << "Tuesday" << endl;
			break;
		case 2: case 3: case 11:
			if(d%7 == 0) cout << "Saturday" << endl;
			if(d%7 == 1) cout << "Sunday" << endl;
			if(d%7 == 2) cout << "Monday" << endl;
			if(d%7 == 3) cout << "Tuesday" << endl;
			if(d%7 == 4) cout << "Wednesday" << endl;
			if(d%7 == 5) cout << "Thursday" << endl;
			if(d%7 == 6) cout << "Friday" << endl;
			break;
		case 4: case 7:
			if(d%7 == 0) cout << "Tuesday" << endl;
			if(d%7 == 1) cout << "Wednesday" << endl;
			if(d%7 == 2) cout << "Thursday" << endl;
			if(d%7 == 3) cout << "Friday" << endl;
			if(d%7 == 4) cout << "Saturday" << endl;
			if(d%7 == 5) cout << "Sunday" << endl;
			if(d%7 == 6) cout << "Monday" << endl;
			break;
		case 9: case 12:
			if(d%7 == 0) cout << "Monday" << endl;
			if(d%7 == 1) cout << "Tuesday" << endl;
			if(d%7 == 2) cout << "Wednesday" << endl;
			if(d%7 == 3) cout << "Thursday" << endl;
			if(d%7 == 4) cout << "Friday" << endl;
			if(d%7 == 5) cout << "Saturday" << endl;
			if(d%7 == 6) cout << "Sunday" << endl;
			break;
		case 5:
			if(d%7 == 0) cout << "Thursday" << endl;
			if(d%7 == 1) cout << "Friday" << endl;
			if(d%7 == 2) cout << "Saturday" << endl;
			if(d%7 == 3) cout << "Sunday" << endl;
			if(d%7 == 4) cout << "Monday" << endl;
			if(d%7 == 5) cout << "Tuesday" << endl;
			if(d%7 == 6) cout << "Wednesday" << endl;
			break;
		case 6:
			if(d%7 == 0) cout << "Sunday" << endl;
			if(d%7 == 1) cout << "Monday" << endl;
			if(d%7 == 2) cout << "Tuesday" << endl;
			if(d%7 == 3) cout << "Wednesday" << endl;
			if(d%7 == 4) cout << "Thursday" << endl;
			if(d%7 == 5) cout << "Friday" << endl;
			if(d%7 == 6) cout << "Saturday" << endl;
			break;
		case 8:
			if(d%7 == 0) cout << "Friday" << endl;
			if(d%7 == 1) cout << "Saturday" << endl;
			if(d%7 == 2) cout << "Sunday" << endl;
			if(d%7 == 3) cout << "Monday" << endl;
			if(d%7 == 4) cout << "Tuesday" << endl;
			if(d%7 == 5) cout << "Wednesday" << endl;
			if(d%7 == 6) cout << "Thursday" << endl;
			break;
	}
	
	return 0;
}