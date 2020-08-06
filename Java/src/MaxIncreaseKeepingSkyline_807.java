/*
 * @author Evan Timmons
 */

class MaxIncreaseKeepingSkyline_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        int distAdjust = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int currentHeight = grid[row][col];
                if (rowMax[row] < currentHeight) {
                    rowMax[row] = currentHeight;
                }
                if (colMax[col] < currentHeight) {
                    colMax[col] = currentHeight;
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                distAdjust += Math.min(rowMax[row], colMax[col]) - grid[row][col];
            }
        }

        return distAdjust;
    }
}