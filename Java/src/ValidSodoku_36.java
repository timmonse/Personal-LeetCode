class ValidSodoku_36 {
  public boolean isValidSudoku(char[][] board) {
    boolean[] uniqueNums = new boolean[10];
    int currNum = 0;

    // Check the rows
    for (int row = 0; row < 9; row++){
      uniqueNums = new boolean[10];
      for (int col = 0; col < 9; col++) {
        currNum = board[row][col] != '.' ? board[row][col] - '0' : 0;
        if (currNum == 0) {
          continue;
        }
        if (uniqueNums[currNum]) {
          return false;
        } else {
          uniqueNums[currNum] = true;
        }
      }
    }

    uniqueNums = new boolean[10];

    // Check the columns
    for (int col = 0; col < 9; col++){
      uniqueNums = new boolean[10];
      for (int row = 0; row < 9; row++) {
        currNum = board[row][col] != '.' ? board[row][col] - '0': 0;
        if (currNum == 0) {
          continue;
        }
        if (uniqueNums[currNum]) {
          return false;
        } else {
          uniqueNums[currNum] = true;
        }
      }
    }

    uniqueNums = new boolean[10];

    // Check the boxes
    for (int rowStart = 0; rowStart <= 6; rowStart+=3) {
      for (int colStart = 0; colStart <= 6; colStart+=3) {
        uniqueNums = new boolean[10];
        for (int row = rowStart; row < rowStart + 3; row++){
          for (int col = colStart; col < colStart + 3; col++) {
            currNum = board[row][col] != '.' ? board[row][col] - '0': 0;
            if (currNum == 0) {
              continue;
            }
            if (uniqueNums[currNum]) {
              return false;
            } else {
              uniqueNums[currNum] = true;
            }
          }
        }
      }
    }

    return true;
  }
}