//Name:     
//Date:

import java.util.*;
import java.io.*;

public class InsertionSort_Driver {
  public static void main(String[] args) throws Exception {
    // Part 1, for doubles
    int n = (int) (Math.random() * 100) + 20;
    double[] array = new double[n];
    for (int k = 0; k < array.length; k++)
      array[k] = Math.random() * 100;

    Insertion.sort(array); // students write
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

    Insertion.sort(arrayStr); // students write
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
    for (Object temp : papaya)
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

  @SuppressWarnings("unchecked") // this removes the warning for Comparable
public static boolean isAscending(Comparable[] a) {
  // TO DO
  for (int i = 1; i < a.length; i++)
    {
      if (Insertion.compareIgnoreCase(a[i], a[i-1]) < 0)
        return false;
    }
  return true;
}

// **********************************************************

class Insertion {
  public static void sort(double[] array) {
    // TO DO
    for (int i = 1; i < array.length; i++)
      {
        double key = array[i];
        int j = i - 1;
        while (j >= 0 && array[j] > key)
          {
            array [j + 1] = array[j];
            j = j - 1;
          }
      
        array[j + 1] = key;
      }
  }
  

  private static int shift(double[] array, int index, double value) {
    // TO DO
    int i;
    for (i  = index; i >= 0 && array[i] > value; i--)
      {
        array[i + 1] = array[i];
      }
    return i;
  }

  @SuppressWarnings("unchecked")
  public static void sort(Comparable[] array) {
    // TO DO
    for (int i = 1; i < array.length; i++)
      {
        Comparable key = array[i];
        int j = i - 1;
        while (j >= 0 && compareIgnoreCase(array[j], key) > 0)
          {
            array[j + 1] = array[j];
            j = j - 1;
          }
        array[j + 1] = key;
      }
    
  }

  @SuppressWarnings("unchecked")
  private static int shift(Comparable[] array, int index, Comparable value) {
    // TO DO
    int i;
    for (i = index; i >= 0 && compareIgnoreCase(array[i], value) > 0; i--)
      {
        array[i + 1] = array[i];
      }

    return i;
  }

  private static int compareIgnoreCase(Comparable a, Comparable b)
  {
    String strA = a.toString().toLowerCase();
    String strB = b.toString().toLowerCase();
    return strA.compareToIgnoreCase(strB);
  }
}
}

