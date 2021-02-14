public class QueenBoard {
  private int[][] board;

  private boolean addQueen(int r, int c) {
    return (board[r][c] == 0);
  }

  private void removeQueen(int r, int c) {
    board[r][c] = 0;
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
        else {
          result = result + "_ ";
        }
      }
      if(board[i][size-1] == -1) {
        result = result + "Q \n";
      }
      else {
        result = result + "_ \n";
      }
    }
    return result;
  }

}
