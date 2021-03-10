import java.util.*;
import java.io.*;
public class Preliminary {

  public static int partition(int[] data, int start, int end) {
    Random r = new Random();
    int index = Math.abs(r.nextInt() % (end + 1));
    int end1 = end;
    int value = data[index];
    data[index] = data[0];
    data[0] = value;
    int current = 1;
    while(current < end1) {
      if(data[current] > value) {
        int t = data[end1];
        data[end1] = data[current];
        data[current] = t;
        end1--;
      }
      else {
        current++;
      }
    }
    if ((data[current] < value) || data[current] == value && r.nextBoolean()){
      data[0] = data[current];
      data[current] = value;
      return current;
    }
    else {
      data[0] = data[current-1];
      data[current-1] = value;
      return current-1;
    }
  }
  //
  // public static String toString(int[] data) {
  //   String result = "";
  //   for(int i = 0; i < data.length; i++) {
  //     result = result + data[i] + " ";
  //   }
  //   return result;
  // }

}
