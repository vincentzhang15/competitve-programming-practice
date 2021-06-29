#include <bits/stdc++.h>
using namespace std;

int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int t1, t2;
    cin >> t1 >> t2;
    
    if(t1 - t2 > t2) // output is 3
        cout << 3 << endl;
    else // # output is > 3
    {
        int count = 4;
        while (1)
        {
            int t3 = t1 - t2;
            int t4 = t2 - t3;
    
            if (t3 < t4)
            {
                cout << count << endl;
                break;
            }
            count += 1;
            
            t1 = t2;
            t2 = t3;
        }
    }
    
    return 0;
}