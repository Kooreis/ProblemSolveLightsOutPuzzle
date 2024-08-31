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