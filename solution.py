The "Lights Out" puzzle is a game where you have a grid of lights that can be either on or off. The goal is to turn off all the lights. When you toggle a light, it and all of its adjacent lights (up, down, left, right) will switch states.

Here is a Python console application that solves the "Lights Out" puzzle using a breadth-first search algorithm:

```python
from collections import deque
from itertools import product

def toggle(grid, x, y):
    for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1), (0, 0)):
        nx, ny = x + dx, y + dy
        if 0 <= nx < 5 and 0 <= ny < 5:
            grid[nx][ny] ^= 1
    return grid

def solve(grid):
    start = [row[:] for row in grid]
    queue = deque([(start, [])])
    visited = {str(start)}
    while queue:
        grid, presses = queue.popleft()
        if sum(sum(row) for row in grid) == 0:
            return presses
        for x, y in product(range(5), repeat=2):
            new_grid = toggle([row[:] for row in grid], x, y)
            if str(new_grid) not in visited:
                queue.append((new_grid, presses + [(x, y)]))
                visited.add(str(new_grid))

def main():
    grid = [[int(x) for x in input().split()] for _ in range(5)]
    presses = solve(grid)
    for x, y in presses:
        print(x, y)

if __name__ == "__main__":
    main()
```

This program reads a 5x5 grid of 0s and 1s from the console, where 0 represents a light that is off and 1 represents a light that is on. It then uses a breadth-first search to find the shortest sequence of light toggles that turns off all the lights. The sequence of light toggles is printed to the console.