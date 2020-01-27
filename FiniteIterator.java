import java.util.Iterator;

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
 *         This class creates a finite iterator by implementing the Iterator interface. An object of
 *         this class iterates a certain number of terms in the provided sequence.
 */

public class FiniteIterator<T> implements Iterator<T> {

  private InfiniteIterator<T> infinite = null;
  private int length = 0;
  private int nextCounter = 0;

  /**
   * This is the constructor for this class. It creates a new object of this class and initializes
   * all its fields.
   * 
   * @param infinite
   * @param length
   * @return None
   */
  public FiniteIterator(InfiniteIterator<T> infinite, int length) {
    this.infinite = infinite;
    this.length = length;

  }

  /**
   * This method indicates whether or not the sequence has a next term the iterator can output. This
   * method returns true for a user-specified number of terms before returning false.
   * 
   * @param None
   * @return true / false
   */
  @Override
  public boolean hasNext() {

    if (nextCounter < length) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method returns the next term in the given sequence.
   * 
   * @param None
   * @return toReturn
   */
  @Override
  public T next() {

    T toReturn = infinite.next();
    nextCounter++;
    return toReturn;
  }

}
