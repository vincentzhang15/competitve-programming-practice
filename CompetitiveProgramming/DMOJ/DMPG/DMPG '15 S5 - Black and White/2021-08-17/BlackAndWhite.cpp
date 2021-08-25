#include <iostream>

using namespace std;

bool data[10001][10001];
int n, m, a, b, c, d, e;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    for(int i=0; i<m; i++)
    {
        cin >> a >> b >> c >> d;
        data[a][b] ^= 1;
        data[a+c][b] ^= 1;
        data[a][b+d] ^= 1;
        data[a+c][b+d] ^= 1;
    }
    for(int i=0; i<n;i++)
        for(int j=1; j<n; j++)
            data[i][j] ^= data[i][j-1];
    for(int i=1; i<n;i++)
        for(int j=0; j<n; j++)
            data[i][j] ^= data[i-1][j];
    
    for(int i=0; i<n; i++)
        for(int j=0; j<n; j++)
            e += data[i][j];
    cout << e;
    return 0;
}