public class tester{

  @SuppressWarnings("unchecked")
  public static void main(String args[]) {
    MyDeque<Integer> test = new MyDeque<Integer>(10);
    // System.out.println(test.start());
    // System.out.println(test.end());
    test.addFirst(0);
    // System.out.println(test.start());
    // System.out.println(test.end());
    test.addFirst(1);
    // System.out.println(test.start());
    // System.out.println(test.end());
    test.addFirst(2);
    test.addLast(10);
    test.addLast(20);
    // System.out.println(test.start());
    // System.out.println(test.end());
    // System.out.println(test.start());
    System.out.println(test.toString());
  }
}
