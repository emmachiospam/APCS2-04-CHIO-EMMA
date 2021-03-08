import java.util.*;
import java.io.*;
public class USACO {

  public static int bronze(String filename) throws FileNotFoundException{
    File fileName = new File(filename);
    Scanner n = new Scanner(fileName);
    int row = 1;
    String line;
    ArrayList<Integer> first = new ArrayList<Integer>();
    while(n.hasNext() && row == 1) {
      line = n.nextLine();
      Scanner p = new Scanner(line);
      while(p.hasNext()) {
        first.add(Integer.parseInt(p.next()));
      }
      row++;
    }
    int R = first.get(0);
    int C = first.get(1);
    int E = first.get(2);
    int N = first.get(3);
    int[][] ground = new int[R][C];
    while(n.hasNext() && (row > 1 && row < R + 2)) {
      line = n.nextLine();
      Scanner l = new Scanner(line);
      int[] t = new int[C];
      int i = 0;
      while(l.hasNext()) {
        t[i] = Integer.parseInt(l.next());
        i++;
      }
      row++;
      ground[row - 3] = t;
    }
    ArrayList<ArrayList<Integer>> instructions = new ArrayList<ArrayList<Integer>>();
    while(n.hasNext() && (row > R + 1 && row < R + N + 2)) {
      line = n.nextLine();
      Scanner o = new Scanner(line);
      ArrayList<Integer> temp = new ArrayList<Integer>();
      while(o.hasNext()) {
        temp.add(Integer.parseInt(o.next()));
      }
      instructions.add(temp);
      row++;
    }
    for(int i = 0; i < instructions.size(); i++) {
      int r = instructions.get(i).get(0) - 1;
      int c = instructions.get(i).get(1) - 1;
      int e = instructions.get(i).get(2);
      int max = 0;
      for(int j = r; j < r + 3; j++) {
        for(int k = c; k < c + 3; k++) {
          if(ground[j][k] > max) {
            max = ground[j][k];
          }
        }
      }
      for(int q = r; q < r + 3; q++) {
        for(int w = c; w < c + 3; w++) {
          if(ground[q][w] > max - e) {
            ground[q][w] = max - e;
          }
        }
      }
    }
    int total = 0;
    for(int j = 0; j < R; j++) {
      for(int k = 0; k < C; k++) {
        if(ground[j][k] < E) {
          total = total + E - ground[j][k];
        }
      }
    }
    return total * 72 * 72;
  }


  public static long silver(String filename) throws FileNotFoundException{
    File fileName = new File(filename);
    Scanner n = new Scanner(fileName);
    int row = 1;
    String line;
    ArrayList<Integer> first = new ArrayList<Integer>();
    while(n.hasNext() && row == 1) {
      line = n.nextLine();
      Scanner p = new Scanner(line);
      while(p.hasNext()) {
        first.add(Integer.parseInt(p.next()));
      }
      row++;
    }
    int N = first.get(0);
    int M = first.get(1);
    int T = first.get(2);
    int[][] ground = new int[N+2][M+2];
    while(n.hasNext() && (row > 1 && row < N + 2)) {
      line = n.nextLine();
      Scanner l = new Scanner(line);
      int[] t = new int[M+2];
      for(int i = 0; i < line.length(); i++) {
        if(line.charAt(i) == ('.')) {
          t[i+1] = 0;
        }
        else if (line.charAt(i) == '*'){
          t[i+1] = -1;
        }
      }
      row++;
      ground[row - 2] = t;
    }
    ArrayList<Integer> last = new ArrayList<Integer>();
    while(n.hasNext() && row > N + 1) {
      line = n.nextLine();
      Scanner p = new Scanner(line);
      while(p.hasNext()) {
        last.add(Integer.parseInt(p.next()));
      }
      row++;
    }
    // System.out.println(toString(ground));
    int R1 = last.get(0);
    int C1 = last.get(1);
    int R2 = last.get(2);
    int C2 = last.get(3);
    int[][] previous = new int[N+2][M+2];
    previous[R1][C1] = 1;
    for(int i = 0; i < T; i++) {
      int[][] adjusted = new int[N+2][M+2];
      for(int w = 0; w < N+2; w++) {
        adjusted[w] = ground[w].clone();
      }
      for(int j = 1; j < N+1; j++) {
        for(int k = 1; k < M+1; k++) {
          if(adjusted[j][k] != -1) {
            int up = previous[j+1][k];
            int down = previous[j-1][k];
            int left = previous[j][k-1];
            int right = previous[j][k+1];
            if(previous[j-1][k] == -1) {
              down = 0;
            }
            if(previous[j+1][k] == -1) {
              up = 0;
            }
            if(previous[j][k+1] == -1) {
              right = 0;
            }
            if(previous[j][k-1] == -1) {
              left = 0;
            }
            adjusted[j][k] = up + down + right + left;
          }
        }
      }
      for(int w = 0; w < N+2; w++) {
        previous[w] = adjusted[w].clone();
      }
    }
    return previous[R2][C2];
  }


  public static String toString(int[][] test) {
    String result = "";
    int column = test[0].length;
    int row = test.length;
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < column - 1; j++) {
        result = result + test[i][j] + " ";
      }
      result = result + test[i][column-1] + "\n";
    }
    return result;
  }

}
