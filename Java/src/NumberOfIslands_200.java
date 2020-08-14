public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        int islandCount = 0;

        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                int value = grid[row][col];
                if (value == '1') {
                    islandCount++;
                    expandIsland(grid, row, col);
                }
            }
        }
        return islandCount;
    }

    public void expandIsland(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = 0;
        expandIsland(grid, row-1, col);
        expandIsland(grid, row+1, col);
        expandIsland(grid, row, col-1);
        expandIsland(grid, row, col+1);
    }
}
