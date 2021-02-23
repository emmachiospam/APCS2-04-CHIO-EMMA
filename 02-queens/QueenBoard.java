public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  public boolean addQueen(int c, int r) {
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

  public void removeQueen(int c, int r) {
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

  public int[][] board(){
    return board;
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
        // else
        // if(board[i][j] >= 0) {
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
      // else
      // if(board[i][size-1] >= 0) {
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
    else {
      for(int i = 0; i < size; i++) {
        if(addQueen(column, i)) {
          if (solve(column + 1, 0)) {
            return true;
          }
          else {
            removeQueen(column, i);
          }
        }
      }
      return false;
    }
  }


  public int countSolutions() {
    int size = board.length;
    if(size == 0) {
      return 0;
    }
    if(empty() == false) {
      throw new IllegalArgumentException("the board cannot start with non-zero values");
    }
    else {
      return countSolutions(0);
    }
  }

  public int countSolutions(int column) {
    int size = board.length;
    int total = 0;
    //if the code is able to get to the nth column, it means that it is possible
    if(column == size) {
      return 1;
    }
    for(int i = 0; i < size; i++) {
      if(addQueen(column, i)) {
        total += countSolutions(column + 1);
        removeQueen(column, i);
      }
    }
    return total;
  }


}
