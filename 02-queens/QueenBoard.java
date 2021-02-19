public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  private boolean addQueen(int c, int r) {
    int size = board.length;
    //the queen can only be added if the spot is nonthreatened and not occupied by another queen
    if (board[r][c] == 0) {
      board[r][c] = -1;
      //for every spot in its column, +1 to show that it is a threatened spot
      for(int j = 0; j < size; j++) {
        if(j != r) {
          board[j][c] = board[j][c] + 1;
        }
      }
      int test = 0;
      for(int i = c+1; i < size; i++) {
        //for every spot in its row, +1 to show that it is a threatened spot
        board[r][i] = board[r][i] + 1;
        test++;
        //for every spot in its upward diagonal, +1 to show that it is a threatened spot
        if(r - test > -1) {
          board[r-test][i] = board[r - test][i] + 1;
        }
        //for every spot in its downward diagonal, +1 to show that it is a threatened spot
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

  private void removeQueen(int c, int r) {
    int size = board.length;
    if (board[r][c] == -1) {
      //resets the queens spot to an empty spot
      board[r][c] = 0;
      //for every spot in its column, -1 to show that it is threatened by one less queen
      for(int j = 0; j < size; j++) {
        if(j != r) {
          board[j][c] = board[j][c] - 1;
        }
      }
      int test = 0;
      for(int i = c+1; i < size; i++) {
        //for every spot in its row, -1 to show that it is threatened by one less queen
        board[r][i] = board[r][i] - 1;
        test++;
        //for every spot in its upward diagonal, -1 to show that it is threatened by one less queen
        if(r - test > -1) {
          board[r-test][i] = board[r - test][i] - 1;
        }
        //for every spot in its downward diagonal, -1 to show that it is threatened by one less queen
        if(r + test < size) {
          board[r+test][i] = board[r + test][i] - 1;
        }
      }
    }
  }

  private int[][] board(){
    return board;
  }

  //scans through the board at the given column to find where the row the queen is in
  //in the previous column
  public int findQueen(int c) {
    int size = board.length;
    int row = 0;
    for(int i = 0; i < size; i++) {
      if(board[i][c] == -1) {
        row = i;
      }
    }
    return row;
  }

  public boolean empty() {
    int size = board.length;
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        if(board[i][j] != 0) {
          return false;
        }
      }
    }
    return true;
  }

  public String toString() {
    int size = board.length;
    String result = "";
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size-1; j++) {
        if(board[i][j] == -1) {
          result = result + "Q ";
        }
        // else if(board[i][j] >= 0) {
        //   // result = result + "X ";
        //   result = result + board[i][j] + " ";
        // }
        else {
          result = result + "_ ";
        }
      }
      if(board[i][size-1] == -1) {
        result = result + "Q \n";
      }
      // else if(board[i][size-1] >= 0) {
      //   // result = result + "X \n";
      //   result = result + board[i][size-1] + "\n";
      // }
      else {
        result = result + "_ \n";
      }
    }
    return result;
  }

  public boolean solve() {
    if(empty() == false) {
      throw new IllegalArgumentException("the board cannot start with non-zero values");
    }
    else {
      return solve(0, 0);
    }
  }

  public boolean solve(int column, int row) {
    int size = board.length;
    //if the code is able to get to the nth column, it means that it is possible
    if(column == size) {
      return true;
    }
    //if the code reaches the last row of the first column and there is still no solution,
    //then the situation is not possible
    else if (column == 0 && row == size) {
      return false;
    }
    //if it hits the last row of any other column, it should go back one column
    //and try another solution where the previous queen's position has moved
    else if(row == size) {
      int location = findQueen(column);
      removeQueen(column - 1, location);
      if(solve(column - 1, location + 1)) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      if(addQueen(column, row)) {
        //if the queen can be added, then go to the next column and start at 0
        if(solve(column + 1, 0)) {
          return true;
        }
        else {
          return false;
        }
      }
      else {
        //if the queen cannot be added, then remove the queen that was added and start at
        //the next row
        removeQueen(column, row);
        if(solve(column, row + 1)) {
          return true;
        }
        else {
          return false;
        }
      }
    }
  }

}
