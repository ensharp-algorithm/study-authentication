using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[,] paper = new int[100, 100];
            int answer = 0;

            for(int i = 0; i < n; i++)
            {
                string[] temp = Console.ReadLine().Split(' ');
                int x = int.Parse(temp[0]);
                int y = int.Parse(temp[1]);
                for(int j = x; j < x + 10; j++)
                    for(int  k = y; k < y + 10; k++)
                        paper[j, k] = 1;
            }

            foreach(int value in paper)
                if (value == 1)
                    answer++;
            Console.WriteLine(answer);
        }
    }
}