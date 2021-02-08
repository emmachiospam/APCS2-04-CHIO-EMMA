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

  public static String reverse (String s) {
    if(s.length() == 1) {
      return s;
    }
    else {
      int l = s.length()-1;
      return s.charAt(l) + reverse(s.substring(0,l));
    }
  }

  public static long countNoDoubleLetterWords(int length,String word) {
    if(length == 0) {
      return 1;
    }
    else {
      //looping through all the letters in the array
      long result = 0;
      for(int i = 'a'; i <= 'z'; i++) {
        char add = (char)i;
        int l = word.length()-1;
        //only adding it if the letter at the end if different from the char being added
        if(word.length() > 0 && add == word.charAt(l)) {
        }
        else {
          result = result + countNoDoubleLetterWords(length-1, word + add);
        }
      }
      return result;
    }
  }

  public static double sqrt(double n) {
    if(n == 0) {
      return 0;
    }
    else{
      return newton(n, 1.0);
    }
  }


}
