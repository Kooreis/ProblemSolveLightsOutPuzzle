The "Lights Out" puzzle is a game consisting of a 5 by 5 grid of lights. When the game starts, a random number or a stored pattern of these lights is switched on. Pressing any of the lights will toggle it and the four adjacent lights. The goal of the puzzle is to switch all the lights off, preferably in as few button presses as possible.

Here is a simple Java console application that solves the "Lights Out" puzzle:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] grid = new int[5][6];
        for (int i = 0; i < 5; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                grid[i][j] = line[j] - '0';
            }
        }
        for (int i = 0; i < 32; i++) {
            int[][] temp = new int[5][6];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    temp[j][k] = grid[j][k];
                }
            }
            for (int j = 0; j < 5; j++) {
                if (((i >> j) & 1) == 1) {
                    press(temp, 0, j);
                }
            }
            for (int j = 1; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (temp[j - 1][k] == 1) {
                        press(temp, j, k);
                    }
                }
            }
            if (check(temp)) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        System.out.print(temp[j][k] + " ");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }

    private static void press(int[][] grid, int x, int y) {
        grid[x][y] ^= 1;
        if (x > 0) grid[x - 1][y] ^= 1;
        if (x < 4) grid[x + 1][y] ^= 1;
        if (y > 0) grid[x][y - 1] ^= 1;
        if (y < 4) grid[x][y + 1] ^= 1;
    }

    private static boolean check(int[][] grid) {
        for (int i = 0; i < 5; i++) {
            if (grid[4][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
```

This program reads the initial state of the puzzle from the console, solves it, and then prints the solution to the console. The initial state of the puzzle should be entered as five lines of five digits each, where 0 represents a light that is off and 1 represents a light that is on. The solution is printed in the same format.