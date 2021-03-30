import java.util.*;
import java.io.*;
public class Calculator{

  public static double eval(String s) {
    ArrayDeque<Double> values = new ArrayDeque<Double>();
    double value1 = 0;
    double value2 = 0;
    double result = 0;
    Scanner p = new Scanner(s);
    while(p.hasNext()) {
      String current = p.next();
      if(current.equals("+")) {
        value1 = values.removeLast();
        value2 = values.removeLast();
        result = value1 + value2;
        values.addLast(result);
      }
      else if(current.equals("-")) {
        value1 = values.removeLast();
        value2 = values.removeLast();
        result = value2 - value1;
        values.addLast(result);
      }
      else if(current.equals("*")) {
        value1 = values.removeLast();
        value2 = values.removeLast();
        result = value1 * value2;
        values.addLast(result);
      }
      else if(current.equals("/")) {
        value1 = values.removeLast();
        value2 = values.removeLast();
        result = value2 / value1;
        values.addLast(result);
      }
      else if(current.equals("%")) {
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
      throw new IllegalArgumentException("not enough operands");
    }
    else {
      return values.getFirst();
    }
  }

}
