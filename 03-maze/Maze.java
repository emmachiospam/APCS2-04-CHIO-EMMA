import java.util.*;
import java.io.*;
public class Maze {
  private char[][] maze;
  //false by default
  private boolean animate;

//constructor
  public Maze(String filename) throws FileNotFoundException {
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
    System.out.println("\330[2J");
  }

}
