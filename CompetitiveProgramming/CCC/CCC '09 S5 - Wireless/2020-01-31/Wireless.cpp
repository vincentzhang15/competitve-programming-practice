#include <bits/stdc++.h>
using namespace std;

class CoffeeShop
{
	public:
	int x, y, b;
	double r;
	
	void input()
	{
		cin >> x >> y >> r >> b;
	}
	
	int getDist(int x, int y)
	{
		int dx = x - this->x;
		int dy = y - this->y;
		
		double distance = sqrt(dx*dx+dy*dy);
		
		if(distance <= r)
			return b;
		return 0;
	}
};

int m, n, k;
vector<CoffeeShop> shops;

void calc(int &max, int &nShops)
{
	max = 0;
	nShops = 0;
	for(int x = 1; x <= n; x++)
	{
		for(int y = 1; y <= m; y++)
		{
			int maxNum = 0;
			for(int i = 0; i < k; i++)
			{
				maxNum += shops[i].getDist(x, y);
			}
			if(max < maxNum)
			{
				max = maxNum;
				nShops = 0;
			}
			if(maxNum == max)
				nShops++;
		}
	}
}

int main()
{
	cin >> m >> n >> k;
	
	for(int i = 0; i < k; i++)
	{
		CoffeeShop c;
		c.input();
		shops.push_back(c);
	}
	
	int max = 0;
	int nShops = 0;
	calc(max, nShops);
	cout << max << endl << nShops << endl;
	
	return 0;
}
