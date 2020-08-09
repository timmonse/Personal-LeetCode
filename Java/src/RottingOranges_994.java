import java.util.*;

public class RottingOranges_994 {
    class Coor {
        int row;
        int col;
        Coor(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public boolean isValid(int[][] grid) {
            if (row < 0 || row >= grid.length) return false;
            if (col < 0 || col >= grid[0].length) return false;
            return true;
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Coor)) {
                return false;
            }
            Coor coor = (Coor) o;
            return row == coor.row && col == coor.col;
        }
        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    Map<Coor, Integer> map = new HashMap<>();
    int longestPath = 0;

    public int orangesRotting(int[][] grid) {
        Set<Coor> pathSet;
        int val;
        int width = grid.length;
        int height = grid[0].length;
        for (int row = 0; row < width; ++row) {
            for (int col = 0; col < height; ++col) {
                val = grid[row][col];
                if (val == 0) continue;
                Coor coor = new Coor(row, col);
                if (val == 2) map.put(coor, 0);
                pathSet = new HashSet<>();
                int shortestPath = shortestPath(grid, coor, 0, pathSet);
                if (shortestPath == Integer.MAX_VALUE) return -1;
                if (shortestPath > longestPath) longestPath = shortestPath;
                map.put(coor, shortestPath);
            }
        }

        return (longestPath >= 0) ? longestPath : -1;
    }

    int[] rows = {-1, 0, 0, 1};
    int[] cols = {0, -1, 1, 0};

    public int shortestPath(int[][] grid, Coor coor, int pathLength, Set<Coor> pathSet) {
        // If rotten orange, return path length
        if (grid[coor.row][coor.col] == 2) return pathLength;
        if (map.containsKey(coor)) return map.get(coor) + pathLength;

        pathSet.add(coor);

        int shortestNeighbor = Integer.MAX_VALUE;

        for (int i = 0; i < 4; ++i) {
            Coor neighbor = new Coor(coor.row + rows[i], coor.col + cols[i]);
            if (!neighbor.isValid(grid) || pathSet.contains(neighbor) || grid[neighbor.row][neighbor.col] == 0) continue;
            Set<Coor> nextPath = new HashSet<>(pathSet);
            int length = shortestPath(grid, neighbor, pathLength + 1, nextPath);
            if (length < shortestNeighbor) shortestNeighbor = length;
        }

        return shortestNeighbor;
    }
}
