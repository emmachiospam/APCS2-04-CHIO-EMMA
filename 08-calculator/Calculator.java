import java.util.*;
import java.io.*;
public class Calculator{

  public static void main(String[] args) {
    System.out.println(eval("4 2 3 5 1 - + * + *"));
  }

  public static double eval(String s) {
    ArrayDeque<Double> values = new ArrayDeque<Double>();
    double value1 = 0;
    double value2 = 0;
    double result = 0;
    Scanner p = new Scanner(s);
    while(p.hasNext()) {
      String current = p.next();
      if(current.equals("+")) {
        if(values.size() < 2) {
          throw new IllegalArgumentException("not enough operands");
        }
        value1 = values.removeLast();
        value2 = values.removeLast();
        result = value1 + value2;
        values.addLast(result);
      }
      else if(current.equals("-")) {
        if(values.size() < 2) {
          throw new IllegalArgumentException("not enough operands");
        }
        value1 = values.removeLast();
        value2 = values.removeLast();
        result = value2 - value1;
        values.addLast(result);
      }
      else if(current.equals("*")) {
        if(values.size() < 2) {
          throw new IllegalArgumentException("not enough operands");
        }
        value1 = values.removeLast();
        value2 = values.removeLast();
        result = value1 * value2;
        values.addLast(result);
      }
      else if(current.equals("/")) {
        if(values.size() < 2) {
          throw new IllegalArgumentException("not enough operands");
        }
        value1 = values.removeLast();
        value2 = values.removeLast();
        result = value2 / value1;
        values.addLast(result);
      }
      else if(current.equals("%")) {
        if(values.size() < 2) {
          throw new IllegalArgumentException("not enough operands");
        }
        value1 = values.removeLast();
        value2 = values.removeLast();
        int temp = (int) Math.floor(value2 / value1);
        result = value1 - temp;
        values.addLast(result);
      }
      else {
        values.addLast(Double.parseDouble(current));
      }
    }
    if(values.size() > 1) {
      throw new IllegalArgumentException("too many operands");
    }
    else {
      return values.getFirst();
    }
  }

}
