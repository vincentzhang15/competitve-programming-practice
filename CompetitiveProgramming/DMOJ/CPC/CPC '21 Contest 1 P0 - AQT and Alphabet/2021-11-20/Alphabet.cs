using System;

namespace Alphabet
{
    class Alphabet
    {
        public static void Main(string[] args)
        {
            string s = Console.ReadLine();

            for(char c = 'a'; c <= 'f'; c++)
            {
                if(!s.Contains(c.ToString()))
                {
                    Console.WriteLine(c);
                    break;
                }
            }
        }
    }
}