#include <bits/stdc++.h>
using namespace std;

vector<int> a;
vector<int> b;

int n, m;

int save [3100];
int maxNum = 0;

void input()
{
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		int t;
		cin >> t;
		a.push_back(t);
	}

	cin >> m;
	for(int i = 0; i < n; i++)
	{
		int t;
		cin >> t;
		b.push_back(t);
	}
}

int getMax(vector<int> &a, int k)
{
	// save
	if(k >= a.size())
		return 0;
	if(save[k] != 0)
		return save[k];
	
	int x = getMax(a, k+1);
	int y = a[k] + getMax(a, k+2);
	int z = a[k] + getMax(a, k+3);
	//cout << "1y: " << y << "\ta[k]: " << a[k] << "\tk:" << k << endl;
	//cout << "y: " << y << "\ta[k]: " << a[k] << "\tk:" << k << endl;
	//cout << k << ":" << a[k] << ":    x:" << x << "\t y:" << y << "\t z:" << z << endl;
	//cout << k << ":    x:" << x << endl;
	
	
	int max = x;
	if(x > y && x > z){}
	else if(y > x && y > z)
		max = y;
	else
		max = z;
	
	//cout << "k: " << k << "\t max: " << max << "\tx:" << x << "\ty:" << y << "\tz:" << z << endl;
	save[k] = max;
	return max;
}


void resetSave()
{
	for(int i = 0; i < 3100; i++)
		save[i] = 0;
}


vector<int> c;
void insertList(vector<int> &a, vector<int> &b, int im)
{
	//cout << im << endl;
	if(im >= b.size())
	{
		resetSave();
		int max = getMax(a, 0);
		//cout << im << ":" << max << endl;
		if(max > maxNum)
			maxNum = max;
		cout << "max: " << maxNum << endl;
	}
	
	
	c = a;
	for(int i = 0; i < n; i++)
	{
		//cout << i << ":" << m << endl;
		vector<int>::iterator it = c.begin() + i;
		c.insert(it, b[im]);
		cout << im << ":" << b[im] << ":" << b.size() << endl;
		//cout << i << ": " << im << endl;
		insertList(c, b, ++im);
		//cout << "test" << endl;
	}
}

int main()
{
	input();
		
	if(m > 0)
	{
		insertList(a, b, 0);
	}
	else
	{
		resetSave();
		maxNum = getMax(a, 0);
	}
	cout << maxNum << endl;
}