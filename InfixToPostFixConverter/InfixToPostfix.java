//name:   date: 
import java.util.*;
public class InfixToPostfix
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   public static final String operators = "+-*/";

   public static void main(String[] args)
   {
     System.out.println("Infix  \t-->\tPostfix\t\t-->\tEvaluate");
     ArrayList<String> infixExp = new ArrayList<String>();
     infixExp.add("3+4*5");
     infixExp.add("3*4+5");
     infixExp.add("(4+5)-5*3");
     infixExp.add("(3+4)*(5+6)");
     infixExp.add("(3*(4+5)-2)/5");
     infixExp.add("8+1*2-9/3");
     infixExp.add("8*3/5");     
       
     for( String infix : infixExp )
     {
        String pf = infixToPostfix(infix);  //get this conversion to work first
        System.out.println(infix + "\t\t\t" + pf + "\t\t\t" + PostfixEval.eval(pf));  //PostfixEval must work!
     }
   }

    public static String infixToPostfix(String infix) 
    {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
  
        for (char ch : infix.toCharArray()) 
        {
            if (Character.isDigit(ch)) 
            {
                postfix.append(ch);
            } 
              
            else if (operators.indexOf(ch) != -1) 
            {
                while (!stack.isEmpty() && isHigherOrEqual(stack.peek(), ch) && stack.peek() != '(') 
                {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            } 
              
            else if (LEFT.indexOf(ch) != -1) 
            {
                stack.push(ch);
            } 
            
            else if (RIGHT.indexOf(ch) != -1) 
            {
                char leftMatch = LEFT.charAt(RIGHT.indexOf(ch));
                while (!stack.isEmpty() && stack.peek() != leftMatch) 
                {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
        }
  
        while (!stack.isEmpty()) 
        {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }







   //write isStrictlyLower, isHigherOrEqual, or getLevel:
   /* method goes here */
   public static boolean isStrictlyLower(char op1, char op2)
  {
    return getLevel(op1) < getLevel(op2);
  }

  public static boolean isHigherOrEqual(char op1, char op2)
  {
    return getLevel(op1) >= getLevel(op2);
  }

  public static int getLevel(char op)
  {
    if (op == '+' || op == '-')
    {
      return 1;
    }
    else if (op == '*' || op == '/')
    {
      return 2;
    }
    else if (op == '(' || op == ')' || op == '[' || op == ']' || op == '{' || op == '}')
    {
      return 3;
    }
    else
    {
      return -1;
    }
  }
}
	
/*
 Infix  -->  	Postfix  -->  Evaluate
 3+4*5       	345*+       	23
 3*4+5       	34*5+       	17
 (4+5)-5*3      45+53*-        -6
 (3+4)*(5+6)    34+56+*       	77
 (3*(4+5)-2)/5  345+*2-5/       5
 8+1*2-9/3      812*+93/-       7
 8*3/5		83*5/		4
*/
