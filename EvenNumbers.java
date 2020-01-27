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
 *         This class contains all the methods and variables for a class representing an even number
 *         iterator.
 */

public class EvenNumbers implements Iterator<Integer> {

  /**
   * This method answers the question whether the iterator has a next term in the sequence. Given
   * the nature of this sequence (even numbers), this method always returns true.
   * 
   * @param none
   * @return true
   */
  @Override
  public boolean hasNext() {
    return true;
  }

  /**
   * This method returns the next term in the even number sequence.
   * 
   * @param None
   * @return toReturn
   */
  @Override
  public Integer next() {

    Integer toReturn = num + 2 * iterator;
    iterator++;
    return toReturn;
  }

  private Integer iterator = 0;
  private Integer num = null;

  /**
   * This is the constructor for the EvenNumbers class. It creates an object of the class and
   * initializes all the instance variables.
   * 
   * @param num
   * @return None
   */
  public EvenNumbers(Integer num) {
    this.num = num;

  }

}
