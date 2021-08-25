#include <iostream>
#include <string>
#include <algorithm>

int alpha[26];

int main(int argc, char **argv)
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::string line ;
    std::getline(std::cin, line);

    for(int i=0; i<26; i++)
    {
        char c = (char)(i + 97);
        int count = 0;
        for(size_t j=0; j<line.length(); j++)
        {
            if(line[j] == c)
            {
                count++;

            }
        }
        alpha[i] = count;
    }
    std::sort(alpha, alpha+26);

    int sum = 0;
    for(int i=0; i<26-2; i++)
    {
        sum += alpha[i];
    }
    std::cout << sum << '\n';

    return 0;
}