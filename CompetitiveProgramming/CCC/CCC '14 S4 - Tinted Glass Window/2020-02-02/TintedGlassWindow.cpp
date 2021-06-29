#include <bits/stdc++.h>
using namespace std;

class Brake
{
	public:
	long long y1, y2, t;
	
	Brake(long long top, long long bottom, long long tint)
	{
		y1 = top;
		y2 = bottom;
		t = tint;
	}
};

struct Tint
{
    long long dy, t;
    Tint()
    {
        dy = t = 0;
    }
};

int main()
{
	map<long long, Tint> tint; // y-coord, tint
	map<long long, vector<Brake>> br; // x coord; y1, y2, tint
	
	int n, tintValue;
	cin >> n >> tintValue;
	int x1, y1, x2, y2, t;
	for(int i = 0; i < n; i++)
	{
		cin >> x1 >> y1 >> x2 >> y2 >> t;
		tint[y1] = Tint();
		tint[y2] = Tint();
		br[x1].push_back(Brake(y1, y2, t));
		br[x2].push_back(Brake(y1, y2, -t));
	}
	
	for(map<long long, Tint>::iterator it = tint.begin(); it != tint.end(); it++)
	{
		map<long long, Tint>::iterator it1 = it; it1++;
		it->second.dy = (it1 == tint.end())?0:(it1->first - it->first);
	}
	
	long long area = 0, lastX = 0;
	for(auto &bb : br)
	{
		long long x = bb.first;
		for(auto &t : tint)
			if(t.second.t >= tintValue)
				area += t.second.dy * (x-lastX);
		
		for(auto &b : bb.second)
			for(map<long long, Tint>::iterator it = tint.find(b.y1); it != tint.end(); it++)
			{
				if(b.y2 <= it->first)
					break;
				tint[it->first].t += b.t;
			}
		
		lastX = x;
	}
	
	cout << area << endl;
	
	return 0;
}