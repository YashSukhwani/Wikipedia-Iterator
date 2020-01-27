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
 *         This class creates an iterator that iterates a given function to infinity. It does this
 *         by implementing the Iterator interface.
 */

public class InfiniteIterator<T> implements Iterator<T> {

  /**
   * This method indicates whether sequence has a next term. Since it is an infinite iterator, this
   * method always returns true.
   * 
   * @param None
   * @return true
   */
  @Override
  public boolean hasNext() {
    return true;
  }

  /**
   * This method finds and returns the next term in the sequence provided to the object of this
   * class.
   * 
   * @param None
   * @return toReturn
   */
  @Override
  public T next() {

    T toReturn = num;
    num = generator.apply(num);

    return toReturn;
  }


  private T num = null;
  private Function<T, T> generator = null;

  /**
   * This is the constructor for the InfiniteIterator class. It creates a new object of this class
   * and initializes all its instance fields.
   * 
   * @param num
   * @param generator
   * @return None
   */
  public InfiniteIterator(T num, Function<T, T> generator) {
    this.num = num;
    this.generator = generator;

  }

}
