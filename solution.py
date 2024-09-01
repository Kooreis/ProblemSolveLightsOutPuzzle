def solve(grid):
    start = [row[:] for row in grid]
    queue = deque([(start, [])])
    visited = {str(start)}
    while queue:
        grid, presses = queue.popleft()
        if sum(sum(row) for row in grid) == 0:
            return presses