#include <bits/stdc++.h>
using namespace std;

unordered_set<int> vis;
vector<int> grid[10500000];

int dfs(int S, int E)
{
    stack<int> st;
    st.push(S);
    vis.insert(S);
    while(!st.empty())
    {
        int top = st.top();
        st.pop();

        for(int d : grid[top])
        {
            if(vis.count(d) == 0)
            {
                vis.insert(d);
                st.push(d);
            }
        }
    }

    return vis.count(E);
}

bool can_escape(int N, int M, vector<vector<int>> v)
{
    for(int i=1; i<=N; i++)
    {
        for(int j=1; j<=M; j++)
        {
            grid[i*j].push_back(v[i][j]);
        }
    }

    return dfs(1, M*N);
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