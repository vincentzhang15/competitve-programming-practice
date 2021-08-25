#include <bits/stdc++.h>
using namespace std;

const int MAX = 20000000;
pair<int, int> grid[MAX];

int lastCell[MAX];
int vis [MAX];

int dfs(int s)
{
    vis[s] = true;

    for(int i=lastCell[s]; i != -1; i=grid[i].second)
    {
        if(!vis[grid[i].first])
        {
            dfs(grid[i].first);
        }
    }
    return 0;

}

bool can_escape(int N, int M, vector<vector<int>> v)
{
    for(int i=0; i<MAX; i++)
    {
        lastCell[i] = -1;
    }
    int k = 0;
    for(int i=1; i<=N; i++)
    {
        for(int j=1; j<=M; j++)
        {
            grid[k] = {v[i][j], lastCell[i*j]};
            lastCell[i*j] = k++;
        }
    }
    dfs(1);

    return vis[M*N];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    cin >> n >> m;

    vector<vector<int>> data;
    data.resize(10500000);

    for(int i=0; i<=n; i++)
        data[i].push_back(0);

    for(int i=1; i<=n; i++)
        for(int j=1; j<=m; j++)
        {
            int val;
            cin >> val;
            data[i].push_back(val);
        }
    
    cout << (can_escape(n, m, data) ? "yes" : "no") << '\n';

    return 0;
}