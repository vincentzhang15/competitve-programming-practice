#include <iostream>
#include <queue>

using namespace std;

const int MAX_SQUARE = (int)5e5;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b;
    cin >> a >> b;

    int dist[MAX_SQUARE+1];
    fill(dist, dist + MAX_SQUARE+1, 0x3f3f3f3f);
    dist[a] = 0;

    priority_queue<int> q;
    q.push(-a);
    while(!q.empty())
    {
        int top = -q.top();
        q.pop();

        vector<int> vals;
        int val = top*3;
        if(val <= MAX_SQUARE)
            vals.emplace_back(val);
        
        val = top - 1;
        if(val-1 >= 0)
            vals.emplace_back(val);

        val = top - 3;
        if(val-1 >= 0)
            vals.emplace_back(val);

        val = top / 2;
        if(top % 2 == 0)
            vals.emplace_back(val);

        for(int val : vals)
            if(dist[val] > dist[top] + 1)
            {
                dist[val] = dist[top] + 1;
                q.push(-val);
            }
    }

    cout << dist[b] << '\n';

    return 0;
}