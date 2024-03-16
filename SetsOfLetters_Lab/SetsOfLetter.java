// Name: Brian Tran    Date: 3/13/2024
import java.util.*;
import java.io.*;
public class SetsOfLetters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the file name: ");
      String fileName = sc.next();
    
      fillTheSets(fileName);
   }
   public static void fillTheSets(String fn) throws FileNotFoundException
   {
      // Instantiate set for shared lowercase letters
     Set<Character> sharedLowercase = new TreeSet<Character>();
      // Instantiate set for shared uppercase letters
     Set<Character> sharedUppercase = new TreeSet<Character>();
      // Instantiate set for shared punctuation
     Set<Character> sharedPunctuation = new TreeSet<Character>();
      
      Scanner infile = new Scanner(new File(fn));
      // counter to help in checking for shared letters later on
     int counter = 0;
      // while there are more lines in infile
     while(infile.hasNextLine())
       {
         // increment a counter
         counter++;
            // Instantiate set for lowercase letters in that line
         Set<Character> lowercase = new TreeSet<Character>();
            // Instantiate set for uppercase letters in that line
         Set<Character> uppercase = new TreeSet<Character>();
            // Instantiate set for punctuation in that line
         Set<Character> punctuation = new TreeSet<Character>();
            // read in the next line
         String line = infile.nextLine();
            // convert line to an array of characters
         char[] lineArray = line.toCharArray();
            // for-each loop through array of characters
         for (char c : lineArray)
           {
             // check if it lowercase
              if (Character.isLowerCase(c))
              {
                 // add it to the appropriate set
                lowercase.add(c);
              }
              // check if it uppercase
             else if (Character.isUpperCase(c))
             {
                 // add it to the appropriate set
                uppercase.add(c);
             }
              // else its a punctuation (but NOT a space)
             else if (c != ' ')
             {
                 // add it to the appropriate set
                punctuation.add(c);
             }
           }
               
            // print line that was read in
              System.out.println(line);
            // print set of lowercase from line
              System.out.println("Lower Case: " + lowercase);        
            // print set of uppercase from line
              System.out.println("Upper Case: " + uppercase);
            // print set of punctuation from line
              System.out.println("Other: " + punctuation);
            // print a blank line
              System.out.println();
            // if the count is 1
              if (counter == 1)
              {
               // set each shared set to the corresponding line sets
                sharedLowercase.addAll(lowercase);
                sharedUppercase.addAll(uppercase);
                sharedPunctuation.addAll(punctuation);
              }
            // otherwise if count is greater than 1
              else if (counter > 1)
              {
                // create 3 iterators - 1 for each shared set
                Iterator<Character> lowerIt = sharedLowercase.iterator();
                Iterator<Character> upperIt = sharedUppercase.iterator();
                Iterator<Character> puncIt = sharedPunctuation.iterator();
                 // do this for each iterator (a total of 3x):
                 // while an iterator hasNext
                while (lowerIt.hasNext())
                  {
                    char c = lowerIt.next();
                    if (!lowercase.contains(c))
                    {
                      lowerIt.remove();
                    }
                  }

                while (upperIt.hasNext())
                {
                  char c = upperIt.next();
                  if (!uppercase.contains(c))
                  {
                    upperIt.remove();
                  }
                }

                while (puncIt.hasNext())
                {
                  char c = puncIt.next();
                  if (!punctuation.contains(c))
                  {
                    puncIt.remove();
                  }
                }   
              }
       }
      // print final shared set of common lowercase
      System.out.println("Common Lower Case: " + sharedLowercase);
      // print final shared set of common uppercase   
      System.out.println("Common Upper Case: " + sharedUppercase);
      // print final shared set of common punctuation
      System.out.println("Common Other: " + sharedPunctuation);
   }
}
/***********************************
  ----jGRASP exec: java SetsOfLetters
 
 We, therefore, the Representatives of the united States of 
 Lower Case: [a, d, e, f, h, i, n, o, p, r, s, t, u, v]
 Upper Case: [R, S, W]
 Other: [ , ]
 
 America, in General Congress, Assembled, appealing to the 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, p, r, s, t]
 Upper Case: [A, C, G]
 Other: [ , ]
 
 Supreme Judge of the world for the rectitude of our intentions,
 Lower Case: [c, d, e, f, g, h, i, l, m, n, o, p, r, s, t, u, w]
 Upper Case: [J, S]
 Other: [ , ]
 
 do, in the Name, and by the Authority of the good People of 
 Lower Case: [a, b, d, e, f, g, h, i, l, m, n, o, p, r, t, u, y]
 Upper Case: [A, N, P]
 Other: [ , ]
 
 these Colonies, solemnly publish and declare, That these United 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, u, y]
 Upper Case: [C, T, U]
 Other: [ ,,]
 
 Colonies are, and of Right ought to be Free and Independent 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, p, r, s, t, u]
 Upper Case: [C, F, I, R]
 Other: [ ,,]
 
 States; that they are Absolved from all Allegiance to the 
 Lower Case: [a, b, c, d, e, f, g, h, i, l, m, n, o, r, s, t, v, y]
 Upper Case: [A, S]
 Other: [ ;]
 
 British Crown, and that all political connection between them 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, w]
 Upper Case: [B, C]
 Other: [ ,]
 
 and the State of Great Britain, is and ought to be totally 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, r, s, t, u, y]
 Upper Case: [B, G, S]
 Other: [ ,]
 
 dissolved; and that as Free and Independent States, they have 
 Lower Case: [a, d, e, h, i, l, n, o, p, r, s, t, v, y]
 Upper Case: [F, I, S]
 Other: [ , , ;]
 
 full Power to levy War, conclude Peace, contract Alliances, 
 Lower Case: [a, c, d, e, f, i, l, n, o, r, s, t, u, v, w, y]
 Upper Case: [A, P, W]
 Other: [ ,]
 
 establish Commerce, and to do all other Acts and Things which 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, r, s, t, w]
 Upper Case: [A, C, T]
 Other: [ ,]
 
 Independent States may of right do. And for the support of this 
 Lower Case: [a, d, e, f, g, h, i, m, n, o, p, r, s, t, u, y]
 Upper Case: [A, I, S]
 Other: [ .]
 
 Declaration, with a firm reliance on the protection of divine 
 Lower Case: [a, c, d, e, f, h, i, l, m, n, o, p, r, t, v, w]
 Upper Case: [D]
 Other: [ ,]
 
 Providence, we mutually pledge to each other our Lives, our 
 Lower Case: [a, c, d, e, g, h, i, l, m, n, o, p, r, s, t, u, v, w, y]
 Upper Case: [L, P]
 Other: [ ,]
 
 Fortunes and our sacred Honor.
 Lower Case: [a, c, d, e, n, o, r, s, t, u]
 Upper Case: [F, H]
 Other: [ .]
 
 Common Lower Case: [d, e, n, o, r, t]
 Common Upper Case: []
 Common Other: [ ]
  ----jGRASP: operation complete.
  ************************************/
