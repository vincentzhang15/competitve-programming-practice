#include <bits/stdc++.h>
using namespace std;

int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int n; cin >> n;
    int data [n][2];
    for(int i = 0; i < n; i++)
        cin >> data[i][0] >> data[i][1];
        
    int width = 0x3f3f3f3f;
    for(int i = 0; i < n; i++)
    {
        for(int j = i+1; j < n; j++)
        {
            int x1 = data[i][0];
            int y1 = data[i][1];
            int x2 = data[j][0];
            int y2 = data[j][1];
            
            int length = max(abs(x2-x1), abs(y2-y1));
            if(length < width)
                width = length;
        }
    }
    cout << width*width << endl;

    return 0;
}