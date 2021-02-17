public class QueenBoard {
  private int[][] board;

  public boolean addQueen(int c, int r) {
    int size = board.length;
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for(int j = 0; j < size; j++) {
        if(j != r) {
          board[j][c] = board[j][c] + 1;
        }
      }
      int test = 0;
      for(int i = c+1; i < size; i++) {
        board[r][i] = board[r][i] + 1;
        test++;
        if(r - test > -1) {
          board[r-test][i] = board[r - test][i] + 1;
        }
        if(r + test < size) {
          board[r+test][i] = board[r + test][i] + 1;
        }
      }
      return true;
    }
    else {
      return false;
    }
  }

  public void removeQueen(int c, int r) {
    int size = board.length;
    if (board[r][c] == -1) {
      board[r][c] = 0;
      for(int j = 0; j < size; j++) {
        if(j != r) {
          board[j][c] = board[j][c] - 1;
        }
      }
      int test = 0;
      for(int i = c+1; i < size; i++) {
        board[r][i] = board[r][i] - 1;
        test++;
        if(r - test > -1) {
          board[r-test][i] = board[r - test][i] - 1;
        }
        if(r + test < size) {
          board[r+test][i] = board[r + test][i] - 1;
        }
      }
    }
  }

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  public String toString() {
    int size = board.length;
    String result = "";
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size-1; j++) {
        if(board[i][j] == -1) {
          result = result + "Q ";
        }
        else if(board[i][j] > 0) {
          result = result + "X ";
          // result = result + board[i][j] + " ";
        }
        else {
          result = result + "_ ";
        }
      }
      if(board[i][size-1] == -1) {
        result = result + "Q \n";
      }
      else if(board[i][size-1] > 0) {
        result = result + "X \n";
        // result = result + board[i][size-1] + "\n";
      }
      else {
        result = result + "_ \n";
      }
    }
    return result;
  }

  // public boolean solve() {
  //   return solve(0, 0, 0);
  // }
  //
  // public boolean solve(int column, int row, int pr) {
  //   int size = board.length;
  //   if((row == size - 1 && column == size - 1) && addQueen(column, row) == false) {
  //     return false;
  //   }
  //   else if((row == size - 1 && column == size - 1) && addQueen(column, row) == true) {
  //     return true;
  //   }
  //   else {
  //     if(addQueen(column, row)) {
  //       if(solve(column + 1, 0, row)) {
  //         return true;
  //       }
  //       else {
  //         return false;
  //       }
  //     }
  //
  //   }
  // }

}
