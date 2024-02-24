/*
Write a method collapse that takes a Stack of integers 
as a parameter and that collapses it by replacing each 
successive pair of integers with the sum of the pair.  
For example, suppose stack A has the sequence of values 
as shown.  The bottom pair should be collapsed into 
9 (7 + 2), the second pair should be collapsed into 
17 (8 + 9), the third pair should be collapsed into 
17 (4 + 13) and so on to yield the stack as shown in stack B. 

A		  B
10		19
9		  8
1		  17
7		  17
13		9
4		
9		
8		
2		
7		

If the stack stores an odd number of elements, the top 
element is not collapsed.  For example, stack C, with 
an odd number of elements as shown, would collapse into 
Stack D, as shown.

C		D
5		5
4		7
3		3
2		
1		

If the stack is empty, the return stack is also empty.

You can only use stacks and/or queues as auxiliary 
storage to solve this problem. You may not use any 
other auxiliary data structures to solve this problem, 
although you can have as many simple variables as you 
like and you may create helper methods. You are limited 
to the stack/queue methods on the cheat sheet. 
You may not solve the problem recursively.

*/
import java.util.*;
public class CollapseStack
{
   public static void main(String[] args)
   {
      Stack<Integer> a = new Stack<Integer>();
      int[] arr1 = {7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
      for(int val : arr1)
         a.push(val);

      System.out.println("Stack A: " + a + " <-- top of stack");

      Stack<Integer> b = collapse(a);
      System.out.println("Stack B: " + b + " <-- top of stack");

      Stack<Integer> c = new Stack<Integer>();
      int[] arr2 = {1, 2, 3, 4, 5};
      for(int val : arr2)
         c.push(val);

      System.out.println("Stack C: " + c + " <-- top of stack");

      Stack<Integer> d = collapse(c);
      System.out.println("Stack D: " + d + " <-- top of stack");
   }

  public static Stack<Integer> collapse(Stack<Integer> stk) 
  {
    Queue<Integer> queue = new LinkedList<Integer>();

    while(!stk.isEmpty())
      {
        queue.add(stk.pop());
      }

    while(!queue.isEmpty())
      {
        stk.push(queue.remove());
      }

    int size = stk.size()/2;

    for (int i = 0; i < size; i++)
      {
        queue.add(stk.pop() + stk.pop());
      }

    if (!stk.isEmpty())
    {
      queue.add(stk.pop());
    }
    

    while (!queue.isEmpty())
      {
        stk.push(queue.remove());
      }

    return stk;
  }

}

/*
Stack A: [7, 2, 8, 9, 4, 13, 7, 1, 9, 10] <-- top of stack
Stack B: [9, 17, 17, 8, 19] <-- top of stack
Stack C: [1, 2, 3, 4, 5] <-- top of stack
Stack D: [3, 7, 5] <-- top of stack
*/
