import java.util.*;
import java.io.*;
public class Frontier {
  private ArrayDeque<int[]> frontier;

  public Frontier(){
    frontier = new ArrayDeque<int[]>();
  }

  public int size() {
    return frontier.size();
  }

  public int[] remove() {
    return frontier.removeFirst();
  }

  public void add(int[] location) {
    frontier.addFirst(location);
  }

}
