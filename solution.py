from collections import deque
from itertools import product

def toggle(grid, x, y):
    for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1), (0, 0)):
        nx, ny = x + dx, y + dy
        if 0 <= nx < 5 and 0 <= ny < 5:
            grid[nx][ny] ^= 1
    return grid