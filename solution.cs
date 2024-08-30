Here is a simple console application in C# that solves the "Lights Out" puzzle. This application assumes a 5x5 grid, and the user inputs the initial state of the grid. The application then calculates and outputs the solution.

```C#
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

        int[,] solution = SolveLightsOut(grid);

        Console.WriteLine("Solution:");
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                Console.Write(solution[i, j] + " ");
            }
            Console.WriteLine();
        }
    }

    static int[,] SolveLightsOut(int[,] grid)
    {
        int[,] solution = new int[5, 5];
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (grid[i, j] == 1)
                {
                    Toggle(solution, i, j);
                }
            }
        }
        return solution;
    }

    static void Toggle(int[,] grid, int x, int y)
    {
        for (int dx = -1; dx <= 1; dx++)
        {
            for (int dy = -1; dy <= 1; dy++)
            {
                if (dx * dx + dy * dy == 1)
                {
                    int nx = x + dx, ny = y + dy;
                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5)
                    {
                        grid[nx, ny] ^= 1;
                    }
                }
            }
        }
        grid[x, y] ^= 1;
    }
}
```

This application reads the initial state of the grid from the console, solves the puzzle, and then prints the solution to the console. The `SolveLightsOut` function calculates the solution by toggling the lights in the same row and column as each light that is initially on. The `Toggle` function toggles a light and its neighbors.