import java.util.*;
import java.io.*;
public class Maze {
  private char[][] maze;
  //false by default
  private boolean animate;

//constructor
  public Maze(String filename) throws FileNotFoundException {
    try {
      ArrayList<String> total = new ArrayList<String>();
      animate = false;
      String line;
      File fileName = new File(filename);
      Scanner n = new Scanner(fileName);
      while(n.hasNext()) {
        line = n.nextLine();
        total.add(line);
      }
      int column = total.get(0).length();
      int row = total.size();
      maze = new char[row][column];
      for(int i = 0; i < row; i++) {
        for(int j = 0; j < column; j++) {
          maze[i][j] = total.get(i).charAt(j);
        }
      }
    }
    catch(FileNotFoundException e) {
      throw new FileNotFoundException("File not found");
      // System.out.println("file not found");
    }
  }

  public void wait(int millis) {
    try{
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b) {
    animate = b;
  }

  public static void clearTerminal() {
    //erase terminal
    System.out.println("\033[2J");
  }

  public static void gotoTop() {
    System.out.println("\033[1;1H");
  }

  public String toString() {
    String result = "";
    int rows = maze.length;
    int columns = maze[0].length;
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns-1; j++) {
        result = result + maze[i][j];
      }
      result = result + maze[i][columns-1] + "\n";
    }
    return result;
  }

  public int Srow() {
    for(int i = 0; i < maze.length; i++) {
      for(int j = 0; j < maze[0].length; j++) {
        if(maze[i][j] == 'S') {
          return i;
        }
      }
    }
    return 0;
  }

  public int Scolumn() {
    for(int i = 0; i < maze.length; i++) {
      for(int j = 0; j < maze[0].length; j++) {
        if(maze[i][j] == 'S') {
          return j;
        }
      }
    }
    return 0;
  }

  public int solve() {
    if(animate) {
      clearTerminal();
    }
    return solve(Srow(), Scolumn());
  }


  public int solve(int row, int column) {
    maze[row][column] = '@';
    if(animate) {
      gotoTop();
      System.out.println(this);
      wait(50);
    }
    if(maze[row][column + 1] == 'E') {
      return 1;
    }
    else if(maze[row + 1][column] == 'E') {
      return 1;
    }
    else if(maze[row][column - 1] == 'E') {
      return 1;
    }
    else if(maze[row - 1][column] == 'E') {
      return 1;
    }
    else {
      int count = 0;
      if(maze[row][column + 1] == ' ') {
        count = 1 + solve(row, column + 1);
        if(count > 0) {
          return count;
        }
      }
      if(maze[row + 1][column] == ' ') {
        count = 1 + solve(row + 1, column);
        if(count > 0) {
          return count;
        }
      }
      if(maze[row][column - 1] == ' ') {
        count = 1 + solve(row, column - 1);
        if(count > 0) {
          return count;
        }
      }
      if(maze[row - 1][column] == ' ') {
        count = 1 + solve(row - 1, column);
        if(count > 0) {
          return count;
        }
      }
      maze[row][column] = '.';
      if(animate) {
        gotoTop();
        System.out.println(this);
        wait(50);
      }
      return -1;
    }
  }

}
