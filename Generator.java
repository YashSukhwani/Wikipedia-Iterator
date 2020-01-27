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
 *         This class represents a generator for iterators. An object of this class can generate
 *         both finite and infinite iterators. The following class contains all the fields and
 *         methods used to achieve this.
 */

public class Generator<T> implements Iterable<T> {

  /**
   * This method returns an iterator of the generic type the generator uses.
   * 
   * @param None
   * @return finiteReturn / infiniteReturn
   */
  @Override
  public Iterator<T> iterator() {

    InfiniteIterator<T> infiniteReturn = new InfiniteIterator<T>(firstValue, generateNextFromLast);

    if (firstConstructor) {
      return infiniteReturn;
    } else {
      FiniteIterator<T> finiteReturn = new FiniteIterator<T>(infiniteReturn, length);
      return finiteReturn;
    }

  }

  private T firstValue = null;
  private Function<T, T> generateNextFromLast = null;
  private int length = 0;

  // this field helps decide which kind of iterator the Iterator method in this class must return.
  private boolean firstConstructor = false;

  /**
   * This is the first constructor of the Generator class. It creates an object of the Generator
   * class and initializes all its fields.
   * 
   * @param firstValue
   * @param generateNextFromLast
   * @return None
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast) {
    this.firstValue = firstValue;
    this.generateNextFromLast = generateNextFromLast;
    this.firstConstructor = true; // indicates the constructor without the length parameter was used
  }

  /**
   * This is the second constructor of the Generator class. It creates an object of this class and
   * initializes all its fields.
   * 
   * @param firstValue
   * @param generateNextFromLast
   * @param length
   * @return None
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast, int length) {
    this.firstValue = firstValue;
    this.generateNextFromLast = generateNextFromLast;
    this.length = length;
    this.firstConstructor = false; // indicates the constructor with the length parameter was used
  }

}
