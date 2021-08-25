#include <iostream>
#include <string>

std::string line1, line2;

std::string lower(std::string ext)
{
    for(size_t i=0; i<ext.length(); i++)
    {
        if((int)ext[i] >= 65 && (int)ext[i] <= 90)
        {
            ext[i] = (char)((int)ext[i]-65 + 97);
        }
    }
    return ext;
}

int find(std::string s, char c)
{
    for(std::size_t i=0; i<s.length(); i++)
    {
        if(s[i] == c)
        {
            return i;
        }
    }
    return -1;
}

int main(int argc, char *argv[])
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::getline(std::cin, line1);
    int found = find(line1, '.');
    if(found != -1)
    {
        std::string ext = lower(line1.substr(found+1, line1.length()-found));
        std::cout << "\"" << line1.substr(0, found) << "\" - " << ext << '\n';
    }
    else
    {
        std::getline(std::cin, line2);
        std::cout << "\"" << line1 << "\" - " << lower(line2) << '\n';
    }

    return 0;
}