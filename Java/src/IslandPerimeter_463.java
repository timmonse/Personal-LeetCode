class IslandPerimeter_463 {
    public int islandPerimeter(int[][] grid) {
        int perimCount = 0;
        int[] rowOffset = {-1, 1, 0, 0};
        int[] colOffset = {0, 0, -1, 1};
        int currRow, currCol;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    for (int i = 0; i < 4; i++) {
                        currRow = row + rowOffset[i];
                        currCol = col + colOffset[i];
                        if (currRow < grid.length && currRow >= 0 && currCol < grid[0].length && currCol >= 0) {
                            if (grid[currRow][currCol] != 1) {
                                perimCount++;
                            }
                        } else {
                            perimCount++;
                        }
                    }
                }
            }
        }

        return perimCount;
    }
}
