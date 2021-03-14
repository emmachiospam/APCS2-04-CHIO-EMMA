import java.util.*;
import java.io.*;
public class Quick {

  public static int partition(int[] data, int start, int end) {
    Random r = new Random();
    int difference = Math.abs(end - start);
    int index = Math.abs(r.nextInt() % (difference + 1)) + start;
    int end1 = end;
    int value = data[index];
    data[index] = data[start];
    data[start] = value;
    int current = 1 + start;
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
      data[start] = data[current];
      data[current] = value;
      return current;
    }
    else {
      data[start] = data[current-1];
      data[current-1] = value;
      return current-1;
    }
  }

  public static String toString(int[] data) {
    String result = "";
    for(int i = 0; i < data.length; i++) {
      result = result + data[i] + " ";
    }
    return result;
  }

  public static int quickselect(int[] data, int k) {
    int start = 0;
    int end = data.length-1;
    int current = partition(data, start, end);
    while(current != k) {
      if(current < k) {
        start = current + 1;
        end = data.length - 1;
      }
      else if (current > k){
        start = 0;
        end = current-1;
      }
      current = partition(data, start, end);
    }
    return data[k];
  }

}
