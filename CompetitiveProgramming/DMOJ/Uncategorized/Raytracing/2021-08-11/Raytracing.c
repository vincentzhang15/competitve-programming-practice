/*
10
3 3 9 4 7 6 6 6 0 3
10
1 2 4 4 5
1 4 8 2 3
2 5 3
1 4 7 0 6
1 1 4 1 2
1 0 2 0 2
1 0 9 0 4
2 5 6
1 0 7 0 1
2 3 3

*/

#include <stdio.h>

#pragma GCC optimize("Ofast")

int main()
{
    int n;
    scanf("%d", &n);

    int h[n];
    for(int i=0; i<n; i++)
        scanf("%d", &h[i]);

    int q;
    scanf("%d", &q);
    for(int i=0; i<q; i++)
    {
        int c;
        scanf("%d", &c);

        int a, b;
        scanf("%d", &a);
        scanf("%d", &b);

        if(c == 2)
        {
            h[a] = b;
        }
        else
        {
            int d, e;
            scanf("%d", &d);
            scanf("%d", &e);

            int count = 0;
            for(int i=a; i<=b; i++)
            {
                if(h[i] >= d && h[i] <= e)
                {
                    count++;
                }
            }
            printf("%d\n", count);

        }
    }


    return 0;
}