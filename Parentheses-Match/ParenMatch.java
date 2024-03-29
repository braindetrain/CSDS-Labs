// Name: Brian Tran
// Date: 2/6/2024

import java.util.*;

public class ParenMatch
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   
   public static void main(String[] args)
   {
      System.out.println("Parentheses Match");
      ArrayList<String> parenExp = new ArrayList<String>();

      parenExp.add("5 + 7");
      parenExp.add("( 15 + -7 )");
      parenExp.add(" ) 5 + 7 (");
      parenExp.add("( ( 5.0 - 7.3 ) * 3.5 )");
      parenExp.add("< { 5 + 7 } * 3 >	");
      parenExp.add("[ ( 5 + 7 ) * ] 3	");
      parenExp.add("( 5 + 7 ) * 3");
      parenExp.add("5 + ( 7 * 3 )	");
      parenExp.add("( ( 5 + 7 ) * 3	");
      parenExp.add("[ ( 5 + 7 ] * 3 )");
      parenExp.add("[ ( 5 + 7 ) * 3 ] )");
      parenExp.add("( [ ( 5 + 7 ) * 3 ]	");
      parenExp.add("( ( ( ) $ ) )");
      parenExp.add("( ) [ ]");

   
      for( String s : parenExp )
      {
         boolean good = checkParen(s);
         if(good)
            System.out.println(s + "\t good!");
         else
            System.out.println(s + "\t BAD");
      }
   }
     
   //returns the index of the left parentheses or -1 if it is not there
   public static int isLeftParen(String p)
   {
      return LEFT.indexOf(p);
   }
  
   //returns the index of the right parentheses or -1 if it is not there
   public static int isRightParen(String p)
   {
      return RIGHT.indexOf(p);
   }
   
   public static boolean checkParen(String exp)
   {
     Stack<Character> stack = new Stack<>();
     for (char c: exp.toCharArray())
       {
         if (isLeftParen(String.valueOf(c)) != -1)
         {
           stack.push(c);
         }
         else if (isRightParen(String.valueOf(c)) != -1)
         {
            if (stack.isEmpty())
            {
             return false;
            }
            else
            {
              char top = stack.pop();
              if (LEFT.indexOf(top) != RIGHT.indexOf(c))
              {
                return false;
              }
            }
          }
        }
         
     return stack.isEmpty();    
   }
}

/*****************************************

Parentheses Match
5 + 7		 good!
( 15 + -7 )		 good!
) 5 + 7 (		 BAD
( ( 5.0 - 7.3 ) * 3.5 )		 good!
< { 5 + 7 } * 3 >		 good!
[ ( 5 + 7 ) * ] 3		 good!
( 5 + 7 ) * 3		 good!
5 + ( 7 * 3 )		 good!
( ( 5 + 7 ) * 3		 BAD
[ ( 5 + 7 ] * 3 )		 BAD
[ ( 5 + 7 ) * 3 ] )		 BAD
( [ ( 5 + 7 ) * 3 ]		 BAD
( ( ( ) $ ) )		 good!
( ) [ ]		 good!
 
 *******************************************/
