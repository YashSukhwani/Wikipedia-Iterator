//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           A program that iterates through Wikipedia pages
// Files:           TestDriver.java     EvenNumbers.java        Generator.java
//                  InfiniteIterator.java       FiniteIterator.java    
//                  NextWikiLink.java
// Course:          CS 300, Spring 2019
//
// Author:          Yash Sukhwani
// Email:           sukhwani@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   XXX Write-up states that pair programming is allowed for this assignment.
//   XXX We have both read and understand the course Pair Programming Policy.
//   XXX We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * @author yashsukhwani
 *
 *         This class represents a function that iterates through the Wikipedia website using the
 *         first hyperlink on the page. It also contains the more important main method for this
 *         project.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NextWikiLink implements Function<String, String> {

  /**
   * This method scrapes web data and implements the clicking of the first hyperlink on the webpage.
   * 
   * @param t
   * @return (String)
   */
  @Override
  public String apply(String t) {
    try {
      // Download a Wikipedia page, using t in their internal link format: /wiki/Some_Subject
      Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
      // Use .css selector to retrieve a collection of links from this page's description
      // "p a" selects links within paragraphs
      // ":not([title^='Help'])" skips pronunciations
      // ":not(sup a)" skips citations
      Elements links = doc.select("p a:not([title^='Help']):not(sup a)");
      // return the link attribute from the first element of this list
      return links.get(0).attr("href");
      // Otherwise return an appropriate error message:
    } catch (IOException | IllegalArgumentException e) {
      return "FAILED to find wikipedia page: " + t;
    } catch (IndexOutOfBoundsException e) {
      return "FAILED to find a link in wikipedia page: " + t;
    }
  }

  /**
   * This is the most important method for this project. It runs the program by creating objects of
   * other classes and calling their methods.
   * 
   * @param args
   * @return None
   */
  public static void main(String[] args) {
    // Implement your own Wikipedia crawling application here.
    // 1. prompt the user to enter a topic name and number of iterations to follow
    // 2. prepend "/wiki/" to the user's input, and replace spaces with underscores 
    // 3. use a for-each loop to iterate through the number of links requested
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a wikipedia page topic: ");
    String topic = sc.nextLine();
    
    System.out.print("Enter the number of pages you'd like to step through: ");
    
    boolean exitLoop = false;
    String inputLine = "";
    String [] splitLine = null;
    int numPages = 0;
    int i = 0;
    
    if (sc.hasNextInt()) {
      inputLine = sc.nextLine();
      splitLine = inputLine.split(" ");
      
      if (splitLine.length == 1) {
        splitLine = splitLine[0].split("\t");
        if (splitLine.length == 1) {
          try {
       numPages = Integer.parseInt(splitLine[0]);

          
       
       if (numPages > 0) {
        exitLoop = true; 
       }
          } catch (Exception e) {}
      } }
      
      if (!exitLoop) {
        System.out.print("WARNING: Enter a valid number for pages to traverse through: ");
      }
    }
    
    while (!exitLoop) {
      if (i != 0) {
     System.out.print("WARNING: Enter a valid number for pages to traverse through: "); }
     
     if (sc.hasNextInt()) {
       
       inputLine = sc.nextLine().trim();
       
       while (inputLine.equals("")) { // to solve the number format exception
        inputLine = sc.nextLine().trim(); 
       }
       
       // System.out.println(inputLine);
       splitLine = inputLine.split("\n");
       if (splitLine.length == 1) {
       
       
       splitLine = splitLine[0].split(" ");
       
       if (splitLine.length == 1) {
         splitLine = splitLine[0].split("\t");
         if (splitLine.length == 1) {
           try {
        numPages = Integer.parseInt(splitLine[0]);
        
        if (numPages > 0) {
         exitLoop = true; 
        } } catch (Exception e) {}
        
       } } }
     }
     else {
              
       inputLine = sc.nextLine().trim();
       
       while (inputLine.equals("")) { // to solve the number format exception
        inputLine = sc.nextLine().trim(); 
       }
              
     } i++;
    }
    
    if (topic == null) {
     topic = ""; 
    }
    
    topic = topic.trim();
    topic = topic.replaceAll(" ", "_");
    topic = "/wiki/" + topic;
    
    NextWikiLink wikiFunction = new NextWikiLink();
    
    Generator<String> generate = new Generator<String>(topic, wikiFunction, numPages);
    
    for (Object result : generate) {
      System.out.println(result);
      
      if (result.toString().contains("FAILED to find")) {
       break; 
      }
    }
    
    sc.close();
  }
}
