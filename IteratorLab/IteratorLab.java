// Name: Brian Tran 
// Date: 2/1/2024
// Use for-each loops or iterators, not regular for-loops
// You must use at least two of each in your program

import java.io.*;
import java.util.*;

public class IteratorLab {
  public static void main(String[] args) {
    System.out.println("Iterator Lab\n");
    int[] rawNumbers = { -9, 4, 2, 5, -10, 6, -4, 24, 20, -28 };
    for (int n : rawNumbers)
      System.out.print(n + " ");
    ArrayList<Integer> numbers = createNumbers(rawNumbers);
    System.out.println("\nArrayList: " + numbers); // Implicit Iterator!
    System.out.println("Count negative numbers: " + countNeg(numbers));
    System.out.println("Average: " + average(numbers));
    System.out.println("Replace negative numbers: " + replaceNeg(numbers));
    System.out.println("Delete zeros: " + deleteZero(numbers));
    String[] rawMovies = { "High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins",
        "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron" };
    ArrayList<String> movies = createMovies(rawMovies);
    System.out.println("Movies: " + movies);
    System.out.println("Movies: " + removeDupes(movies));
  }

  // pre: an array of just int values
  // post: return an ArrayList containing all the values
  public static ArrayList<Integer> createNumbers(int[] rawNumbers) {
    ArrayList<Integer> result = new ArrayList<>();
    for(int i = 0; i < rawNumbers.length; i++)
      {
        result.add(rawNumbers[i]);
      }
    return result;
  }

  // pre: an array of just Strings
  // post: return an ArrayList containing all the Strings
  public static ArrayList<String> createMovies(String[] rawWords) {
    ArrayList<String> myList = new ArrayList<String>();
    for (String str : rawWords)
      myList.add(str);
    return myList;
  }

  // pre: ArrayList a is not empty and contains only Integer objects
  // post: return the number of negative values in the ArrayList a
  public static int countNeg(ArrayList<Integer> a) {
    int count = 0;
    Iterator<Integer> iterator = a.iterator();
    while (iterator.hasNext())
      {
        if (iterator.next() < 0)
          count++;
      }
    return count;
  }

  // pre: ArrayList a is not empty and contains only Integer objects
  // post: return the average of all values in the ArrayList a
  public static double average(ArrayList<Integer> a) {
    int sum = 0;
    for (int num: a)
      {
        sum += num;
      }
    return (double) sum / a.size();
  }

  // pre: ArrayList a is not empty and contains only Integer objects
  // post: replaces all negative values in ArrayList a with 0
  public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a) {
    ArrayList<Integer> result = new ArrayList<>(); 
    for (int num : a)
      {
        result.add(Math.max(0, num));
      }
    return result;
  }

  // pre: ArrayList a is not empty and contains only Integer objects
  // post: deletes all zeros in the ArrayList a
  public static ArrayList<Integer> deleteZero(ArrayList<Integer> a) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int num : a) 
      {
        if (num != 0)
        {
          result.add(num);
        }
      }
    return result;
  }

  // pre: ArrayList a is not empty and contains only String objects
  // post: return an ArrayList without duplicate movie titles
  // (Note: you do not have to return a - it can be a different list)
  // strategy: start with an empty arraylist and add movies as needed
  public static ArrayList<String> removeDupes(ArrayList<String> a) {
    ArrayList<String> result = new ArrayList<>();
    Iterator<String> iter = a.iterator();
    while (iter.hasNext())
      {
        String movie = iter.next();
        if (!result.contains(movie))
        {
          result.add(movie);
        }
      }

    return result;
  }

}
