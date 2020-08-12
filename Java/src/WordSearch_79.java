import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        char[] toFind = word.toCharArray();
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (board[row][col] == toFind[0] && dfs(board, toFind, 0, row, col))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] toFind, int index, int row, int col) {
        if (index == toFind.length) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length)
            return false;
        if (board[row][col] != toFind[index]) return false;
        if (board[row][col] == '!') return false;

        char temp = board[row][col];
        board[row][col] = '!';

        if (dfs(board, toFind, index+1, row - 1, col) ||
                dfs(board, toFind, index+1, row, col - 1) ||
                dfs(board, toFind, index+1, row, col + 1) ||
                dfs(board, toFind, index+1, row + 1, col))
            return true;

        board[row][col] = temp;

        return false;
    }
}
