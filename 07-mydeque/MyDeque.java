import java.util.*;
import java.io.*;
public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
    size = 0;
    start = 3;
    end = 3;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = initialCapacity/2;
    end = initialCapacity/2;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] temp = (E[])new Object[2 * size];
    int index = size/4;
    int current = start;
    while(current != end) {
      if(current == data.length) {
        current = 0;
      }
      temp[index] = data[current];
      index++;
      current++;
    }
    start = size/4;
    end = start + size;
    data = temp;
  }

  public int size() {
    return size;
  }

  public int start() {
    return start;
  }

  public int end() {
    return end;
  }

  public String toString() {
    String result = "{";
    int index = start;
    while(index != end) {
      if(index == data.length) {
        index = 0;
      }
      result = result + data[index] + ", ";
      index++;
    }
    result = result + data[index] + "}";
    return result;
  }

  public void addFirst(E element) {
    if(element == null) {
      throw new NullPointerException("Element " + element +
        " can not be null");
    }
    if(data[start] != null) {
      start--;
    }
    if(start == -1) {
      start = data.length - 1;
    }
    if(start == end && data[end] != null) {
      resize();
    }
    data[start] = element;
    size++;
  }

  public void addLast (E element) {
    if(element == null) {
      throw new NullPointerException("Element " + element +
        " can not be null");
    }
    if(data[end] != null) {
      end++;
    }
    if(end == data.length) {
      end = 0;
    }
    if(end == start && data[start] != null) {
      resize();
    }
    size++;
    data[end] = element;
  }

  public E removeFirst() {
    if(size == 0) {
      throw new NoSuchElementException("no such element exists if deque is empty");
    }
    E removed = data[start];
    data[start] = null;
    start++;
    size--;
    return removed;
  }

  public E removeLast() {
    if(size == 0) {
      throw new NoSuchElementException("no such element exists if deque is empty");
    }
    E removed = data[end];
    data[end] = null;
    end--;
    size--;
    return removed;
  }

  public E getFirst() {
    if(size == 0) {
      throw new NoSuchElementException("no such element exists if deque is empty");
    }
    E first = data[start];
    return first;
  }

  public E getLast() {
    if(size == 0) {
      throw new NoSuchElementException("no such element exists if deque is empty");
    }
    E last = data[end];
    return last;
  }

}
