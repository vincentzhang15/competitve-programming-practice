/*
CCC '18 J3 - Are we there yet?

O(1) solution by simplying adding.

@author Vincent Zhang
@since 28 June 2022
@context C++ Review
*/

#include <iostream>

int main()
{
    std::cin.sync_with_stdio(0);
    std::cin.tie(0);

    int a, b, c, d;
    std::cin >> a >> b >> c >> d;

    printf("0 %d %d %d %d \n", a, a+b, a+b+c, a+b+c+d);
    printf("%d 0 %d %d %d \n", a, b, b+c, b+c+d);
    printf("%d %d 0 %d %d \n", a+b, b, c, c+d);
    printf("%d %d %d 0 %d \n", a+b+c, b+c, c, d);
    printf("%d %d %d %d 0 \n", a+b+c+d, b+c+d, c+d, d);
    return 0;
}
