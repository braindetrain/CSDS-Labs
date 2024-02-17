//name: Brian     date: 2/7/24
//purpose: to evaluate postfix expressions
import java.util.*;
public class PostfixEval
{
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postExp = new ArrayList<String>();
      //tests to evaluate
      postExp.add("345*+");
      postExp.add("34*5+");
      postExp.add("45+53*-");
      postExp.add("34+56+*");
      postExp.add("345+*2-5/");
      postExp.add("812*+93/-");
      postExp.add("83*5/");

      //evaluating each postfix expression and printing
      for( String pf : postExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }

  //method to evaluate postfix expressions
   public static int eval(String postfix)
   {
     Stack<Integer> stack = new Stack<Integer>();
     for (char ch : postfix.toCharArray())
       {
         if (isOperator(ch))
         {
           int b = stack.pop(); //pops the top
           int a = stack.pop(); //pops the next operand
           stack.push(eval(a, b, ch)); //perform the operation then push back to stack
         }
         else
         {
           stack.push(Character.getNumericValue(ch));
         }
       }
     return stack.pop();
   }
   public static int eval(int a, int b, char ch)
   {
     int result = 0;
     if (ch == '+') //addition
     {
       result = a + b;
     }
     else if (ch == '-') //subtraction
     {
       result = a - b;
     }
     else if (ch == '*') //multiplication
     {
       result = a * b;
     }
     else if (ch == '/') //division
     {
       result = a / b;
     }
     return result;
   }

   public static boolean isOperator(char ch)
   {
     return ch == '+' || ch == '-' || ch == '*' || ch == '/';
   }
}

/*
 Postfix  -->  Evaluate
 345*+		23
 34*5+		17
 45+53*-		-6
 34+56+*		77
 345+*2-5/		5
 812*+93/-		7
 83*5/			4  
 */
