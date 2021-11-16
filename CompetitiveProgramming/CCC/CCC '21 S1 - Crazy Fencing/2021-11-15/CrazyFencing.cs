using System;

namespace CrazyFencing
{
    class CrazyFencing
    {
        public static void Main(string[] args)
        {
            int n = Convert.ToInt32(Console.ReadLine());

            int[] b = Array.ConvertAll<string, int>(Console.ReadLine().Split(' '), int.Parse);
            int[] h = Array.ConvertAll<string, int>(Console.ReadLine().Split(' '), int.Parse);

            int ans = 0;

            for(int i=0; i<n; i++)
            {
                ans += (b[i] + b[i+1]) * h[i];
            }

            Console.Write(ans / 2.0);
        }
    }
}