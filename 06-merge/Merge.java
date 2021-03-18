import java.util.*;
import java.io.*;
public class Merge {

  public static void mergesort(int[] data) {
    int[] temp = new int[data.length];
    mergesort(data, temp, 0, data.length-1);
  }

  public static void mergesort(int[] data, int[] temp, int low, int high) {
    if(high-low > 0) {
      int middle = (high + low) / 2;
      mergesort(data, temp, low, middle);
      mergesort(data, temp, middle + 1, high);
      merge(data, temp, low, middle + 1, high);
    }
  }

  private static void merge(int[] data, int[] temp, int start1, int start2, int high) {
    int current = start1;
    int low = start1;
    int end1 = start2;
    while(start1 < end1 && start2 <= high) {
      if(data[start1] > data[start2]) {
        temp[current] = data[start2];
        start2++;
      }
      else {
        temp[current] = data[start1];
        start1++;
      }
      current++;
    }
    while (start1 < end1) {
      temp[current] = data[start1];
      start1++;
      current++;
    }
    while (start2 <= high) {
      temp[current] = data[start2];
      start2++;
      current++;
    }
    for(int i = low; i <= high; i++) {
      data[i] = temp[i];
    }
  }

}
