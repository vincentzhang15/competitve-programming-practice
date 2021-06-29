#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	int data[n][4];
	multimap<int, int> loc;
	
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < 3; j++)
			cin >> data[i][j];
		data[i][3] = data[i][0]*data[i][1]*data[i][2];
		loc.insert(make_pair(data[i][3], i));
	}
	
	/*
	for(int i = 0; i < n; i++)
	{
		cout << data[i][3] << endl;
	}
	cout << endl;
	
	for(multimap<int, int>::iterator it = loc.begin(); it != loc.end(); it++)
	{
		cout << (*it).first << ":" << (*it).second << endl;
	}
	cout << endl;
	*/
	
	int m;
	cin >> m;
	for(int i = 0; i < m; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		int prod = a*b*c;
		
		bool work = false;
		for(multimap<int, int>::iterator it = loc.begin(); it != loc.end(); it++)
		{
			int j = (*it).second;
			if(prod <= (*it).first)
			{
				int dataSum = data[j][0]+data[j][1]+data[j][2];
				int dataMin = min(data[j][0], min(data[j][1], data[j][2]));
				int dataMax = max(data[j][0], max(data[j][1], data[j][2]));
				int dataMid = dataSum-dataMax-dataMin;
				
				int inSum = a+b+c;
				int inMin = min(a, min(b, c));
				int inMax = max(a, max(b, c));
				int inMid = inSum-inMax-inMin;
				
				//cout << dataMin << ":" << dataMid << ":" << dataMax << ":" << (*it).first << "\t" << inMin << ":" << inMid << ":" << inMax << ":" << prod << "\t" << (inMin <= dataMin) << ":" << (inMid <= dataMid) << ":" << (inMax <= dataMax) << endl;
				
				if(inMin <= dataMin && inMid <= dataMid && inMax <= dataMax)
				{
					cout << (*it).first << endl;
					work = true;
					break;
				}
			}
		}
		if(!work)
			cout << "Item does not fit." << endl;
	}
	
	return 0;
}