/*
Write the reverseDirection method. 
The method takes an input queue of strings that 
contains directions for going to a friend’s house. 
Each string in the input queue consists of one 
letter indicating direction (N, W, S, E) followed 
by the word "on" and a street or road name. 

The method returns an output queue that contains 
directions for returning from the friend’s house 
in a similar format, but with opposite directions 
(N-S are opposites and E-W are opposites).

You can only use stacks and/or queues as auxiliary 
storage to solve this problem. You may not use any 
other auxiliary data structures to solve this problem, 
although you can have as many simple variables as you 
like and you may create helper methods. You are limited 
to the stack/queue methods on the cheat sheet. 
You may not solve the problem recursively.

*/
import java.util.*;
public class ReverseDirection
{
   public static void main(String[] args)
   {
      Queue<String> input = new LinkedList<String>();
      input.add("N on Salisbury Rd");
      input.add("W on Robious Rd");
      input.add("S on I-66");
      input.add("W on Rt 150");

      System.out.println("Input queue");
      for(String s : input)
         System.out.println(s);

      Queue<String> output = reverseDirection(input);
      System.out.println("\nOutput queue");
      for(String s : output)
         System.out.println(s);
   }

   public static Queue<String> reverseDirection (Queue<String> goingTo) 
   {
     Queue<String> reversedDirections = new LinkedList<String>();
     Stack<String> tempStack = new Stack<String>();
     while (!goingTo.isEmpty())
       {
         String direction = goingTo.poll();
         String[] parts = direction.split(" ");
         char originalDirection = parts[0].charAt(0);
         //join street name parts 
         String street = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length));
        //default to original direction
         char reversedDirection = originalDirection;

         //reverse the directions
         if (originalDirection == 'N')
           reversedDirection = 'S';
         else if (originalDirection == 'S')
           reversedDirection = 'N';
         else if (originalDirection == 'E')
           reversedDirection = 'W';
         else if (originalDirection == 'W')
           reversedDirection = 'E';

         String reversed = reversedDirection + " on " + street;
         tempStack.push(reversed);
       }
      //pop elements from the stack to reverse the order of the directions
     while (!tempStack.isEmpty())
       {
         reversedDirections.add(tempStack.pop());
       }
     return reversedDirections;
   }
}

/*
   Input queue
N on Salisbury Rd
W on Robious Rd
S on I-66
W on Rt 150

Output queue
E on Rt 150
N on I-66
E on Robious Rd
S on Salisbury Rd
*/
