import java.util.ArrayList;

class Solution {
  public boolean isValidSudoku(char[][] board) {

    // Iterate through rows
    for (int i = 0; i < 9; i++) {
      ArrayList<Character> list = new ArrayList<>();
      // Iterate through columns
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (list.contains(board[i][j])){
            return false;
          }
          list.add(board[i][j]);
        }
      }
    }

    // Iterate through columns
    for (int j = 0; j < 9; j++) {
      ArrayList<Character> list = new ArrayList<>();
      // Iterate through rows
      for (int i = 0; i < 9; i++) {
        if (board[i][j] != '.') {
          if (list.contains(board[i][j])){
            return false;
          }
          list.add(board[i][j]);
        }
      }
    }

    for (int i = 0; i < 9; i += 3){
      for (int j = 0; j < 9; j += 3){
        // Iterate through columns
        ArrayList<Character> list = new ArrayList<>();
        for (int c = i; c < i + 3; c++) {
          // Iterate through rows
          for (int b = j; b < j + 3; b++) {
            if (board[c][b] != '.') {
              if (list.contains(board[c][b])){
                return false;
              }
              list.add(board[c][b]);
            }
          }
        }
      }
    }
    return true;
  }
}
