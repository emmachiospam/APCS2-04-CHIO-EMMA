import java.util.*;
import java.io.*;
public class MyHeap{

  private static void pushDown(int[]data, int size, int index) {
    int parent = data[index];
    if(2 * index + 2 < size) {
        int child1 = data[2 * index + 1];
        int child2 = data[2 * index + 2];
        int max, maxIndex;
        if(child2 > child1) {
          max = child2;
          maxIndex = 2 * index + 2;
        }
        else {
          max = child1;
          maxIndex = 2 * index + 1;
        }
        if(max > parent) {
          data[maxIndex] = parent;
          data[index] = max;
          if(howManyChildren(size, maxIndex) == 1) {
            if(data[maxIndex * 2 + 1] > data[maxIndex]) {
              pushDown(data, size, maxIndex);
            }
          }
          else if(howManyChildren(size, maxIndex) == 2) {
            if(data[maxIndex * 2 + 1] > data[maxIndex]|| data[maxIndex * 2 + 2] > data[maxIndex]) {
              pushDown(data, size, maxIndex);
            }
          }
        }
    }
    else if(2 * index + 1 < size) {
        int child1 = data[2 * index + 1];
        if(child1 > parent) {
          data[2 * index + 1] = parent;
          data[index] = child1;
          pushDown(data, size, 2 * index + 1);
        }
    }
  }

  private static int howManyChildren(int size, int index) {
    if((index * 2) + 1 < size) {
      if((index * 2) + 2 < size) {
        return 2;
      }
      else{
        return 1;
      }
    }
    else {
      return 0;
    }
  }

  private static void buildHeap(int[] data) {
    for(int i = data.length - 1; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }

  private static void remove(int[] data, int size) {
    int first = data[0];
    data[0] = data[size-1];
    data[size-1] = first;
    size--;
    pushDown(data, size, 0);
  }

  public static void heapsort(int[] data) {
    buildHeap(data);
    for(int i = data.length; i > 0; i--) {
      remove(data, i);
    }
  }


}
