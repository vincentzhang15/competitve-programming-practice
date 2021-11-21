#include <iostream>

int main(int argc, char *argv[])
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::string s;
    std::cin >> s;

    for(int i=97; i<97+6; i++)
    {
        char c = (char)i;
        if(s.find(c) == std::string::npos)
        {
            std::cout << c << '\n';
            break;
        }
    }
}