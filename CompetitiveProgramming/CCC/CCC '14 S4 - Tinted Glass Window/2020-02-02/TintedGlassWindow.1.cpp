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

int main()
{
	map<long long, long long> tint; // y-coord, tint
	map<long long, long long> dy; // y-coord, dy
	map<long long, vector<Brake>> br; // x coord; y1, y2, tint
	
	int n, tintValue;
	cin >> n >> tintValue;
	int x1, y1, x2, y2, t;
	for(int i = 0; i < n; i++)
	{
		cin >> x1 >> y1 >> x2 >> y2 >> t;
		tint[y1] = 0;
		tint[y2] = 0;
		br[x1].push_back(Brake(y1, y2, t));
		br[x2].push_back(Brake(y1, y2, -t));
	}
	
	for(map<long long, long long>::iterator it = tint.begin(); it != tint.end(); it++)
	{
		map<long long, long long>::iterator it1 = it; it1++;
		//cout << (it->first) << ":" << (it1->first) << ":" << (it1 == tint.end()) << endl;
		dy[it->first] = (it1 == tint.end())?0:(it1->first - it->first);
	}
	
	/*
	cout << "TINT" << endl;
	for(map<long long, long long>::iterator it = tint.begin(); it != tint.end(); it++)
	{
		cout << it->first << ":" << it->second << endl;
	}
	cout << endl;
	
	
	cout << "DY" << endl;
	for(map<long long, long long>::iterator it = dy.begin(); it != dy.end(); it++)
	{
		cout << it->first << ":" << it->second << endl;
	}
	cout << endl;

	cout << "BRAKE" << endl;
	for(map<long long, vector<Brake>>::iterator it = br.begin(); it != br.end(); it++)
	{
		cout << it->first << ":";
		for(auto &b : it->second)
			cout << b.y1 << ":" << b.y2 << ":" << b.t << endl;
	}
	cout << endl;
	*/
	
	
	
	
	
	
	
	long long area = 0;
	long long lastX = 0;
	for(auto &bb : br)
	{
		long long x = bb.first;
		for(auto &t : tint)
		{
			//cout << "tint: " << t.first << ":" << t.second << ":" << tintValue << ":" << (t.second >= tintValue) << endl;
			if(t.second >= tintValue)
			{
				area += dy[t.first] * (x-lastX);
				//cout << "area: " << area << endl;
			}
		}
		
		for(auto &b : bb.second)
		{
			for(map<long long, long long>::iterator it = tint.find(b.y1); it != tint.end(); it++)
			{
				if(b.y2 <= it->first)
					break;
				tint[it->first] += b.t;
			}
		}
		
		lastX = x;
	}
	
	cout << area << endl;
	
	return 0;
}