#include <bits/stdc++.h>
using namespace std;

int main()
{
	int columns, shape;
	cin >> columns >> shape;
	
	int data [columns];
	for(int i = 0; i < columns; i++)
	{
		cin >> data[i];
	}
	
	vector<vector<int>> combination;
	if(shape == 1)
	{
		vector<int> v1;
		v1.push_back(1);
		combination.push_back(v1);

		vector<int> v2;
		v2.push_back(1);
		v2.push_back(1);
		v2.push_back(1);
		v2.push_back(1);
		combination.push_back(v2);
	}
	else if(shape == 2)
	{
		vector<int> v1;
		v1.push_back(1);
		v1.push_back(1);
		combination.push_back(v1);
	}
	else if(shape == 3)
	{
		vector<int> v1;
		v1.push_back(1);
		v1.push_back(1);
		v1.push_back(2);
		combination.push_back(v1);

		vector<int> v2;
		v2.push_back(2);
		v2.push_back(1);
		combination.push_back(v2);
	}
	else if(shape == 4)
	{
		vector<int> v1;
		v1.push_back(2);
		v1.push_back(1);
		v1.push_back(1);
		combination.push_back(v1);

		vector<int> v2;
		v2.push_back(1);
		v2.push_back(2);
		combination.push_back(v2);
	}
	else if(shape == 5)
	{
		vector<int> v1;
		v1.push_back(1);
		v1.push_back(1);
		v1.push_back(1);
		combination.push_back(v1);

		vector<int> v2;
		v2.push_back(2);
		v2.push_back(1);
		v2.push_back(2);
		combination.push_back(v2);

		vector<int> v3;
		v3.push_back(1);
		v3.push_back(2);
		combination.push_back(v3);

		vector<int> v4;
		v4.push_back(2);
		v4.push_back(1);
		combination.push_back(v4);
	}
	else if(shape == 6)
	{
		vector<int> v1;
		v1.push_back(1);
		v1.push_back(1);
		v1.push_back(1);
		combination.push_back(v1);

		vector<int> v2;
		v2.push_back(1);
		v2.push_back(1);
		combination.push_back(v2);

		vector<int> v3;
		v3.push_back(1);
		v3.push_back(2);
		v3.push_back(2);
		combination.push_back(v3);

		vector<int> v4;
		v4.push_back(3);
		v4.push_back(1);
		combination.push_back(v4);
	}
	else
	{
		vector<int> v1;
		v1.push_back(1);
		v1.push_back(1);
		v1.push_back(1);
		combination.push_back(v1);

		vector<int> v2;
		v2.push_back(1);
		v2.push_back(1);
		combination.push_back(v2);

		vector<int> v3;
		v3.push_back(2);
		v3.push_back(2);
		v3.push_back(1);
		combination.push_back(v3);

		vector<int> v4;
		v4.push_back(1);
		v4.push_back(3);
		combination.push_back(v4);
	}
	
	int count = 0;
	for(vector<int> i : combination)
	{
		/*
		cout << "--------------" << endl;
		for(int l : i)
			cout << l << " ";
		cout << endl;
		*/

		for(int j = 0; j <= columns-i.size(); j++)
		{
			//cout << "start column: " << j << endl;
			bool fail = false;
			int factor = data[j]-i[0];
			//cout << data[j] << ":" << i[0] << "    factor" << factor << endl;
			for(int k = 1; k < i.size(); k++)
			{
				//cout << i[k] << ":" << data[j] << endl;
				if(data[j+k]-i[k] != factor)
				{
					fail = true;
					break;
				}
			}
			if(!fail)
			{
				count++;
			}
			/*
			if(fail)
				cout << "FAIL" << endl;
			else
				cout << "PASS" << endl;
			*/
		}
	}
	cout << count << endl;
	
	
	return 0;
}