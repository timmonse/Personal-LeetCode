import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class WordSearch_79 {
    class Solution {
        public class Coor {
            int row;
            int col;

            Coor(int row, int col) {
                this.row = row;
                this.col = col;
            }

            boolean isEqual(Coor coor) {
                if (row == coor.row && col == coor.col) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null) {
                    return false;
                }
                if (o instanceof Coor) {
                    Coor test = (Coor) o;
                    if (test.row == this.row && test.col == this.col) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public int hashCode() {
                return Objects.hash(row, col);
            }
        }

        public boolean exist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;
            char curr;
            char first = word.charAt(0);
            Set<Coor> path;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    path = new HashSet<Coor>();
                    Coor c = new Coor(row, col);
                    path.add(c);
                    if (dfs(board, row, col, word, path)) {
                        return true;
                    }
                }
            }

            return false;
        }

        int[] rowOffset = {0,0,-1,1};
        int[] colOffset = {-1,1,0,0};

        public boolean dfs(char[][] board, int row, int col, String word, Set<Coor> path) {
            if (word.charAt(0) != board[row][col]) {
                return false;
            }

            if (word.length() == 1) {
                return true;
            }

            Set<Coor> newPath;

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowOffset[i];
                int newCol = col + colOffset[i];
                Coor newCoor = new Coor(newRow, newCol);
                if (isValid(board, newRow, newCol) && !path.contains(newCoor)) {
                    newPath = new HashSet<Coor>();
                    newPath.add(newCoor);
                    newPath.addAll(path);
                    if (dfs(board, newRow, newCol, word.substring(1), newPath)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isValid(char[][] board, int row, int col) {
            if ((row < board.length && row >= 0) && (col < board[0].length && col >= 0)) {
                return true;
            } else {
                return false;
            }
        }
    }


}
