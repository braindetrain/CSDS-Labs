// Brian Tran
// 9/17/2023
// Pig Latin lab
//Program that translates English words or sentences into Pig Latin
import java.util.*;
import java.io.*;

public class PigLatin
{
   public static void main (String [] args) throws Exception
   {
      // *** UNCOMMENT ONLY ONE PART AT A TIME FOR TESTING ***
      
      part1();      // user input and display output
      //part2(); // file input/output
   }
    
   // reads words from user at run-time and displays pig latin equivalent
   public static void part1()
   {
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("\nwhat word? (-1 to exit) ");
         String s = sc.next();
         if (s.equals("-1"))
         {
            System.exit(0);
            sc.close();
         }
         String p = pig(s);
         System.out.println(p);
      }
   }
   
   // reads words from file at run-time and writes pig latin equivalents to file
   public static void part2() throws Exception
   {
        Scanner sc = new Scanner(System.in);
        PrintWriter outfile = new PrintWriter("output.txt");
  
        // For Part 2, replace these next two lines with a try-catch exception
        // Refer to page 'ReadWriteFiles_Exceptions.pdf'
        // The code will be similar to the code in the pdf (although not exact)
        try
        {
          System.out.print("Enter input filename: ");
          Scanner infile = new Scanner(new File(sc.nextLine()));
                
          while(infile.hasNextLine())
          {
            String line = infile.nextLine();
            String [] words = line.split(" ");
            for (int i = 0; i < words.length; i++)
            {
              String p = pig(words[i]);
              outfile.print(p + " ");
            }
            outfile.println();
          }          
          infile.close();
          outfile.close();
       }
        catch (FileNotFoundException e)
       {
         System.out.println("File not found");
         sc.close();
       }
   }

   // returns the pig latinized version of the word s
  public static String pig(String s)
   {
      // ******** PUT YOUR CODE HERE **********

     //if the word does not contain a vowel then it isn't a real word
     if (!containsVowel(s))
     {
    return "**** INVALID ****";
     }

    //instantiating characters for future use 
    char firstChar = s.charAt(0);
    char secondChar;
    if (s.length() > 1)
    {
      secondChar = s.charAt(1);
    }
    else 
    {
      secondChar = '\0';
    }
    int firstVowelIndex = findFirstVowelIndex(s);
    boolean isCapitalized = Character.isUpperCase(firstChar);
    int lastIndex = (s.length() - 1);
    String punctuation = "";

    //run for the duration of the word excluding special characters, keep punctuation in the spot that they were
    while (lastIndex >= 0 && !Character.isLetterOrDigit(s.charAt(lastIndex)))
      {
        punctuation = s.charAt(lastIndex) + punctuation;
        s = s.substring(0, lastIndex);
        lastIndex--;
      }

    //uncapitalize the letter that was originally capitalized to make sure there isn't a random capitalized letter in the text
    if (isCapitalized)
    {
      s = s.substring(0, 1).toLowerCase() + s.substring(1);
    }
    //if the starting letter is a vowel append way
    if (isVowel(firstChar) || (firstChar == 'y' && firstVowelIndex > 0))
     {
       s = (s + "way").toLowerCase();
     }
    //if the starting letters are q and u, append both q and u 
    else if (firstChar == 'q' && secondChar == 'u')
    {
      String prefix = s.substring(0, 2);
      String suffix = s.substring(2);
      s = (suffix + prefix + "ay").toLowerCase();
    }
    //in all other cases, just append ay to the end
    else 
     {
        String prefix = s.substring(0, firstVowelIndex);
        String suffix = s.substring(firstVowelIndex);
        s = (suffix + prefix + "ay").toLowerCase();
     }

     //if the first letter of the plaintext was capital, capitalize the first letter of the ciphertext
     if (isCapitalized) 
     {
       s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
     }
     return s + punctuation;
   }
   
   // ********* PUT ANY OF YOUR HELPER METHODS HERE **********
  //if the word contains a vowel, return true, else return false
  public static boolean containsVowel(String word)
  {
    for (char c: word.toCharArray())
      {
        if (isVowel(c))
        {
          return true;
        }
      }
    return false;
  }
  //if the letter passed is a vowel, return true, else return false
  public static boolean isVowel(char c)
  {
    return "AEIOUYaeiouy".indexOf(c) != -1;
  }

  //search the word for a vowel, the first vowel found breaks the loop
  public static int findFirstVowelIndex(String word) 
  {
    for (int i = 0; i < word.length(); i++) 
      {
        char c = word.charAt(i);
        if (isVowel(c)) 
        {
          return i;
        }
      }
    return -1;
  }
}
