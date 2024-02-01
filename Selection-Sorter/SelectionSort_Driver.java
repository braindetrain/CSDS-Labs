// Name: Brian Tran
// Date: 12/6/23

import java.util.*;
import java.io.*;

public class SelectionSort_Driver {
  public static void main(String[] args) throws Exception {
    // Part 1, for doubles
    int n = (int) (Math.random() * 100) + 20;
    double[] array = new double[n];
    for (int k = 0; k < array.length; k++)
      array[k] = Math.random() * 100;

    Selection.sort(array); // students must write
    print(array);
    if (isAscending(array))
      System.out.println("In order!");
    else
      System.out.println("Out of order  :-( ");
    System.out.println();

    // Part 2, for Strings
    int size = 100;
    Scanner sc = new Scanner(new File("declaration.txt"));
    Comparable[] arrayStr = new String[size];
    for (int k = 0; k < arrayStr.length; k++)
      arrayStr[k] = sc.next();

    Selection.sort(arrayStr); // students must write
    print(arrayStr);
    System.out.println();

    if (isAscending(arrayStr))
      System.out.println("In order!");
    else
      System.out.println("Out of order  :-( ");
  }

  public static void print(double[] a) {
    // for(int k = 0; k < a.length; k++)
    // System.out.println(a[k]);
    for (double temp : a) // for-each
      System.out.println(temp + " ");
    System.out.println();
  }

  public static void print(Object[] papaya) {
    for (Object temp : papaya) // for-each
      System.out.println(temp + " ");
  }

  public static boolean isAscending(double[] a) {
    for (int i = 1; i < a.length; i++)
      {
        if (a[i] < a[i-1])
          return false;
      }
    return true;
  }

  @SuppressWarnings("unchecked")
  public static boolean isAscending(Comparable[] a) {
    // TO DO
    for (int i = 1; i < a.length; i++)
      {
        if (Selection.compareIgnoreCase(a[i], a[i-1]) < 0)
          return false;
      }
    return true;
  }

/////////////////////////////////////////////////////

class Selection {
  public static void sort(double[] array) {
    for (int i = array.length - 1; i >= 1; i--)
      {
        int max = findMax(array, i);
        swap(array, i, max);
      }
    
  }

  // upper controls where the inner loop of the Selection Sort ends
  private static int findMax(double[] array, int upper) {
    // TO DO
    int max = 0;
    for (int i = 1; i <= upper; i++)
      {
        if (array[i] > array[max])
          max = i;
      }
    return max;
  }

  private static void swap(double[] array, int a, int b) {
    // TO DO
    double temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  /******* for Comparables ********************/
  @SuppressWarnings("unchecked")
  public static void sort(Comparable[] array) {
    // TO DO
    for (int i = array.length - 1 ; i >= 1; i--)
      {
        int max = findMax(array, i);
        swap(array, i, max);
      }
    
  }

  @SuppressWarnings("unchecked")
  public static int findMax(Comparable[] array, int upper) {
    // TO DO
    int max = 0;
    for (int i = 1; i <= upper; i++)
      {
        if (compareIgnoreCase(array[i], array[max]) > 0)
        {
          max = i;
        }
      }
    return max;
  }

  //added this method because i didn't like that the uppercase and lowercase letters were separate in sorting, meaning that a Z would come before a in supposed alphabetical order because its capital
  private static int compareIgnoreCase(Comparable a, Comparable b)
  {
    String strA = a.toString().toLowerCase();
    String strB = b.toString().toLowerCase();
    return strA.compareToIgnoreCase(strB);
  }

  public static void swap(Comparable[] array, int a, int b) {
    // 
    Comparable temp = array[a];
    array[a] = array[b];
    array[b] = temp;

  }
}
}
