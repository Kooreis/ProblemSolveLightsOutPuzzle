using System;
using System.Linq;

class Program
{
    static void Main()
    {
        int[,] grid = new int[5, 5];
        for (int i = 0; i < 5; i++)
        {
            Console.WriteLine("Enter row " + (i + 1) + " (5 digits 0 or 1, separated by space):");
            string[] input = Console.ReadLine().Split(' ');
            for (int j = 0; j < 5; j++)
            {
                grid[i, j] = int.Parse(input[j]);
            }
        }