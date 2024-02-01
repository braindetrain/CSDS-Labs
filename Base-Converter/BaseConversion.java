// ******************************************************************
// BaseConversion.java
// Student Name: Brian Tran
//
// Recursively converts an integer from base 10 to another base
// Recursively or iteratively converts a number from another base to base 10
// ******************************************************************
import java.util.Scanner;
public class BaseConversion
{
  public static void main( String[] args )
  {
    int base10Num;
    int base;
    String otherBaseNum;
    Scanner scan = new Scanner( System.in );
    System.out.println();
    System.out.println( "Base Conversion Program" );
    System.out.print( "Enter an integer: " );
    base10Num = scan.nextInt();
    System.out.print( "Enter the base: " );
    base = scan.nextInt();
    // Call convert and print the answer
    System.out.println( "The base " + base + " value of " + base10Num + " is " + convert(base10Num, base) );


    // To check coverting from other base to decimal
    scan.nextLine();
    System.out.print( "Enter an number in a different base: " );
    otherBaseNum = scan.nextLine();
    System.out.print( "Enter the base: " );
    base = scan.nextInt();
    //Call convertToDecimal and print the answer
    System.out.println("The decimal value of " + otherBaseNum + " is " + convertToDecimal(otherBaseNum, base));
   
   }
 
 // --------------------------------------------------------------
 // Converts a base 10 number to another base *recursively*
 // --------------------------------------------------------------
  public static String convert( int num, int b )
  {
    //base case, 0 is always equal to 0
    if (num == 0)
    {
      return "0";
    }

    //if base is greater than 10, we have to start using characters to represent digits 
    if (num < b)
    {
      return digitToString(num);
    }

    int quotient = num / b;
    int remainder = num % b;
    
    //recursive case 
    return convert(quotient, b) + digitToString(remainder);
  }
 
 // --------------------------------------------------------------
 // TODO: Take in an int and convert it to it's
 // hexadecimal representation. Remember 10 == "A", 11 == "B"
 // etc... once you fill this out, use it in convert()
  public static String digitToString( int iVal )
  {
    //if the digit is less than 10, it does not need to be represented with characters 
    if (iVal < 10)
    {
      return Integer.toString(iVal);
    }

    //changes digits to characters
    else
    {
      char basecar = (char) ('A' + (iVal - 10));
      return String.valueOf(basecar);
    }
  }

  // --------------------------------------------------------------
  // Converts another base to base 10 iteratively or recursively
  // --------------------------------------------------------------
  public static int convertToDecimal( String num, int b )
  {
    int decimal = 0;
    int baseMultiplier = 1;

    //iterates through the string backwards
    for (int i = num.length() - 1; i >= 0; i--)
      {
        //takes the character at the index and converts it to a digit
        int digit = stringToDigit(String.valueOf(num.charAt(i))); 
        //formula for converting to decimal
        decimal += digit * baseMultiplier;
        baseMultiplier *=b;
      }
    return decimal;
  }

  // --------------------------------------------------------------
  // Take in a String and convert it to it's decimal representation. 
  public static int stringToDigit( String sVal )
  {
    if (sVal.length() == 1)
    {
      char cVal = sVal.charAt(0);
      if (Character.isDigit(cVal))
      //if the character is a digit, the character's value is immediately returned
      {
        return cVal - '0';
      }
      //else, the character is a letter, and the character's value must be derived 
      else 
      {
        return cVal - 'A' + 10;
      }
    }
    return -1;
  }
}
