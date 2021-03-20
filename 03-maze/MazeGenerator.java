import java.io.*;
import java.util.*;
public class MazeGenerator {

  public static void main(String args[]) {
  }

  public static String toString(char[][] maze) {
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

  public static char[][] createMaze(int rows, int columns) {
    char[][] maze = new char[rows][columns];
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        maze[i][j] = '#';
      }
    }
    return maze;
  }

  public static void generate(char[][] maze) {
    generate(maze, 0, 0, 1, 1);
  }

  public static void generate(char[][] maze, int x, int y, int row, int column) {
    maze[row][column] = ' ';
    int[] order = new int[4];
    for(int i = 0; i < 4; i++) {
      order[i] = i;
    }
    for(int i = 0; i < 4; i++) {
      Random r = new Random();
      int j = Math.abs(r.nextInt() % 4);
      int temp = order[i];
      order[i] = order[j];
      order[j] = temp;
    }
    for(int i = 0; i < 4; i++) {
      int random = order[i];
      if(random == 0) {
        if(howManyAround(maze, row, column + 1) >= 2 ) {
        }
        else {
          generate(maze, 0, 0, row, column + 1);
        }
      }
      if(random == 1) {
        if(howManyAround(maze, row + 1, column) >= 2) {
        }
        else {
          generate(maze, 0, 0, row + 1, column);
        }
      }
      if(random == 2) {
        if(howManyAround(maze, row, column - 1) >= 2) {
        }
        else {
          generate(maze, 0, 0, row, column - 1);
        }
      }
      if (random == 3){
        if(howManyAround(maze, row - 1, column) >= 2) {
        }
        else{
          generate(maze, 0, 0, row - 1, column);
        }
      }
    }
  }

  public static boolean border(char[][] maze, int row, int col) {
    int rowborder = maze.length - 1;
    int colborder = maze[0].length - 1;
    if (row == 0 || row == rowborder) {
      return true;
    }
    else if (col == 0 || col == colborder) {
      return true;
    }
    else {
      return false;
    }
  }

  public static int howManyAround(char[][] maze, int row, int column) {
    int total = 0;
    if(border(maze, row, column)) {
      total = 4;
    }
    else {
      if(maze[row][column + 1] == ' ') {
        total++;
      }
      if(maze[row + 1][column] == ' ') {
        total++;
      }
      if(maze[row][column - 1] == ' ') {
        total++;
      }
      if(maze[row - 1][column] == ' ') {
        total++;
      }
    }
    return total;
  }
}
