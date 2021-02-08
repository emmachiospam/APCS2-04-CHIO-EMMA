public class recursion {

  public static double newton(double number, double guess) {
    // absolute value to ensure that it never goes below 0
    // make sure that it only returns when it only has a difference of .001% or less
    if(Math.abs(((guess * guess) - number)/number) < 0.00001) {
      return guess;
    }
    else {
      return( newton(number, ((number / guess + guess) / 2)));
    }
  }

  public static void main(String[] args) {
    // System.out.println( newton(6.0, 1.0) );
  }

}
