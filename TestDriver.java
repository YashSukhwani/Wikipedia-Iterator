import java.util.Iterator;
import java.util.function.Function;

////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           A program that iterates through Wikipedia pages
//Files:           TestDriver.java     EvenNumbers.java        Generator.java
//                 InfiniteIterator.java       FiniteIterator.java    
//                 NextWikiLink.java
//Course:          CS 300, Spring 2019
//
//Author:          Yash Sukhwani
//Email:           sukhwani@wisc.edu
//Lecturer's Name: Gary Dahl
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    (name of your pair programming partner)
//Partner Email:   (email address of your programming partner)
//Partner Lecturer's Name: (name of your partner's lecturer)
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//XXX Write-up states that pair programming is allowed for this assignment.
//XXX We have both read and understand the course Pair Programming Policy.
//XXX We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
//Persons:         None
//Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * @author yashsukhwani
 * 
 *         This class contains all the test methods for the other class in this project.
 */

public class TestDriver {

  public static void main(String[] args) {
    System.out.println(testEvenNumbers());
    System.out.println(testPowersOfTwo());
    System.out.println(testAddExtraSmile());
    System.out.println(testFiniteIterator());
    System.out.println(testGenerator());

  }

  public static boolean testGenerator() {

    // to test iterators with the NextPowerOfTwo function
    NextPowerOfTwo testFunction = new NextPowerOfTwo();

    // to test an infinite iterator of an Integer type
    Generator<Integer> test1 = new Generator<Integer>(3, testFunction);

    // to test a finite iterator of an Integer type
    Generator<Integer> test2 = new Generator<Integer>(2, testFunction, 6);

    // storing the expected results for iterator2
    int[] iterator2Result = new int[] {2, 4, 8, 16, 32, 64};
    int i = 0; // used as a counter

    // returns false if any output of the Integer finite iterator doesn't match the expected results
    for (Object result : test2) {
      if (i < 7) {
        if (!result.equals(iterator2Result[i])) {
          return false;
        }
      }
      i++;
    }

    // tests the 17th result of the infinite iterator and returns false if the result is not as
    // expected
    i = 0;
    for (Object result : test1) {
      i++;

      if (i == 17) {
        if (!result.equals(196608)) {
          return false;
        }
        break;
      }
    }

    // to test iterators with the AddExtraSmile function
    AddExtraSmile testFunction2 = new AddExtraSmile();

    // to test an infinite iterator of String type
    Generator<String> test3 = new Generator<String>("Hi", testFunction2);

    // to test a finite iterator of String type
    Generator<String> test4 = new Generator<String>("Hey", testFunction2, 5);

    String[] iterator4Result =
        new String[] {"Hey", "Hey :)", "Hey :) :)", "Hey :) :) :)", "Hey :) :) :) :)"};

    // returns false if any output of the String finite iterator doesn't match the expected results
    i = 0;
    for (Object result : test4) {
      if (i < 5) {
        if (!result.equals(iterator4Result[i])) {
          return false;
        }
        i++;
      }
    }

    // tests the 8th result of the infinite iterator & returns false if the result is not as
    // expected
    i = 0;
    for (Object result : test3) {
      i++;
      if (i == 8) {
        if (!result.equals("Hi :) :) :) :) :) :) :)")) {
          return false;
        }
        break;
      }
    }


    return true;
  }

  /**
   * This method tests for the correct implementation the InfiniteIterator class using the
   * AddExtraSmile function.
   * 
   * @param None
   * @return true / false
   */
  public static boolean testAddExtraSmile() {
    InfiniteIterator<String> it = new InfiniteIterator<>("Hello", new AddExtraSmile());
    if (!it.next().equals("Hello")) {
      System.out.println("The first call of InfiniteIterator.next() "
          + "did not return the string passed into its constructor.");
      return false;
    }
    if (!it.next().contains(" :)")) {
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the a string with one more :), "
          + "than the previously returned string.");
      return false;
    }
    if (it.hasNext() != true) {
      System.out
          .println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }

  /**
   * This method tests for the correct implementation of the FiniteIterator class using the
   * NextPowerOfTwo function.
   * 
   * @param None
   * @return true / false
   */
  public static boolean testFiniteIterator() {
    InfiniteIterator<Integer> infinite = new InfiniteIterator<>(2, new NextPowerOfTwo());
    FiniteIterator<Integer> it = new FiniteIterator<>(infinite, 8);
    String s = "";
    while (it.hasNext())
      s += " " + it.next();
    if (!s.equals(" 2 4 8 16 32 64 128 256")) {
      System.out.println("Repeatedly called the next() method of a FiniteIterator,"
          + "and the incorrect valuese were returned:" + s);
      return false;
    }
    return true;
  }

  /**
   * This method tests for the correct implementation of the EvenNumbers class.
   * 
   * @param None
   * @return true / false
   */
  public static boolean testEvenNumbers() {

    EvenNumbers it = new EvenNumbers(44);

    if (it.next() != 44) {
      System.out.println("The first call of EvenNumbers.next() "
          + "did not return the value passed into its constructor.");
      return false;
    }

    if (it.next() != 46) {
      System.out.println(
          "The second call of EvenNumbers.next() " + "did not return the smallest even number, "
              + "that is larger than the previously returned number.");
      return false;
    }

    if (it.hasNext() != true) {
      System.out.println("EvenNumbers.next() returned false, " + "but should always return true.");
      return false;
    }

    return true;
  }

  /**
   * This method tests for the correct implementation of the PowersOfTwo class.
   * 
   * @param None
   * @return true / false
   */
  public static boolean testPowersOfTwo() {
    InfiniteIterator<Integer> it = new InfiniteIterator(8, new NextPowerOfTwo());
    if (it.next() != 8) {
      System.out.println("The first call of InfiniteIterator.next() "
          + "did not return the number passed into its constructor.");
      return false;
    }
    if (it.next() != 16) {
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the smallest power of two number, "
          + "that is larger than the previously returned number.");
      return false;
    }
    if (it.hasNext() != true) {
      System.out
          .println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }


}


/**
 * 
 * @author yashsukhwani
 *
 *         This class represents a function that calculates the next power of two using the previous
 *         term in the sequence. It implements the Function interface.
 */
class NextPowerOfTwo implements Function<Integer, Integer> {

  /**
   * This method calculates the next power of two using the previous value. It is an essential
   * method for any class implementing the function interface.
   * 
   * @param previous
   * @return 2 * previous
   */
  @Override
  public Integer apply(Integer previous) {
    return 2 * previous;
  }
}


/**
 * 
 * @author yashsukhwani
 *
 *         This class represents a function that adds a smile to the end of a string. It is actually
 *         a sequence, which means it uses the previous term to find the next term.
 */
class AddExtraSmile implements Function<String, String> {

  /**
   * This method represents a function that adds a smile at the end of a given string. This method
   * is essential in classes that implement the function interface.
   * 
   * @param t
   * @return t + " :)"
   */
  @Override
  public String apply(String t) {
    return t + " :)";
  }
}


