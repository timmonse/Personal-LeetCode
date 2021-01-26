class PathWithMinimumEffort_1631 {
    int[][] effort;
    public int minimumEffortPath(int[][] heights) {
        effort = new int[heights.length][heights[0].length];

        // Fill effort with -1 to start
        for (int i = 0; i < effort.length; i++) {
            for (int j = 0; j < effort[i].length; j++) {
                effort[i][j] = -1;
            }
        }
        effort[0][0] = 0; // Starting space requires 0 effort to reach

        search(-1,-1,0,0,-1,heights);

        return effort[effort.length - 1][effort[0].length - 1];
    }

    int[] rowOffset = new int[]{-1,1,0,0};
    int[] colOffset = new int[]{0,0,-1,1};
    public void search(int prevRow, int prevCol, int row, int col, int maxAbsDif, int[][] heights){
        for (int i = 0; i < 4; ++i) {
            int nextRow = row + rowOffset[i];
            int nextCol = col + colOffset[i];
            if (!withinMap(nextRow,nextCol,heights)) continue;

            // Make sure not to go backwards
            if (!(nextRow == prevRow && nextCol == prevCol)){
                int tempMaxAbsDif = maxAbsDif;
                if (Math.abs(heights[row][col]-heights[nextRow][nextCol]) > tempMaxAbsDif) {
                    tempMaxAbsDif = Math.abs(heights[row][col]-heights[nextRow][nextCol]);
                }
                // Ensure that going to the space for first time or with least effort
                if (effort[nextRow][nextCol] == -1 || effort[nextRow][nextCol] > tempMaxAbsDif) {
                    effort[nextRow][nextCol] = tempMaxAbsDif;
                    search(row,col,nextRow,nextCol,tempMaxAbsDif,heights);
                }
            }
        }
    }

    public boolean withinMap(int row, int col, int[][] heights){
        if (row < heights.length && row >= 0 && col < heights[0].length && col >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] testIn_1 = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        PathWithMinimumEffort_1631 test = new PathWithMinimumEffort_1631();

        System.out.println(test.minimumEffortPath(testIn_1));
    }
}
