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
    E[] temp = (E[])new Object[size + size];
    int tempIndex = size/2;
    int index = start;
    while(index != end) {
      if(index == data.length) {
        index = 0;
      }
      temp[tempIndex] = data[index];
      index++;
      tempIndex++;
    }
    temp[tempIndex] = data[index];
    start = size/2;
    end = tempIndex;
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
      result += data[index].toString();
      index++;
      if (index != end) {
        result += ", ";
      }
    }
    result += "}";
    return result;
  }

  public void addFirst(E element) {
    if(element == null) {
      throw new NullPointerException("Element " + element +
        " can not be null");
    }
    if(size == data.length-1) {
      resize();
    }
    start--;
    if(start == -1) {
      start = data.length - 1;
    }
    data[start] = element;
    size++;
  }

  public void addLast (E element) {
    if(element == null) {
      throw new NullPointerException("Element " + element +
        " can not be null");
    }
    if(size == data.length-1) {
      resize();
    }
    data[end] = element;
    end++;
    if(end == data.length) {
      end = 0;
    }
    size++;
  }

  public E removeFirst() {
    if(size == 0) {
      throw new NoSuchElementException("no such element exists if deque is empty");
    }
    E removed = data[start];
    data[start] = null;
    start++;
    // account for if start==data.length
    if(start == data.length) {
      start = 0;
    }
    size--;
    return removed;
  }

  public E removeLast() {
    if(size == 0) {
      throw new NoSuchElementException("no such element exists if deque is empty");
    }
    end--;
    // account for end==-1
    if(end == -1) {
      end = data.length - 1;
    }
    size--;
    E removed = data[end];
    data[end] = null;
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
    // decrement end first before accessing data[end]
    int index = end-1;
    if(index == -1) {
      index = data.length-1;
    }
    E last = data[index];
    return last;
  }

}
