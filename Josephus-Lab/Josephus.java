import java.util.*;
import java.io.*;

public class Josephus {
   private static String WINNER = "Josephus";

   public static void main(String[] args) throws FileNotFoundException {
      ListNode last = null;
      last = insert(last, "B");
      last = insert(last, "C");
      last = insert(last, "D");
      last = insert(last, "E");
      last = insert(last, "F");
      print(last);

      Scanner sc = new Scanner(System.in);
      System.out.print("How many names (2-20)? ");
      int n = Integer.parseInt(sc.next());
      System.out.print("How many names to count off each time? ");
      int countOff = Integer.parseInt(sc.next());
     
     ListNode winningPos = numberCircle(n, countOff, "J_numbers.txt");
      System.out.println(winningPos.getValue() + " wins!");

      System.out.println("\n ****  Now start all over. **** \n");
      System.out.print("Where should " + WINNER + " stand?  ");
      int winPos = Integer.parseInt(sc.next());
      ListNode theWinner = josephusCircle(n, countOff, "J_names.txt", winPos);
      System.out.println(theWinner.getValue() + " wins!");
   }

   public static ListNode numberCircle(int n, int countOff, String filename) throws FileNotFoundException {
      ListNode p = null;
      p = readNLinesOfFile(n, new File(filename));
      p = countingOff(p, countOff, n);
      return p;
   }

   public static ListNode josephusCircle(int n, int countOff, String filename, int winPos) throws FileNotFoundException {
      ListNode p = null;
      p = readNLinesOfFile(n, new File(filename));
      replaceAt(p, WINNER, winPos);
      p = countingOff(p, countOff, n);
      return p;
   }

   public static ListNode readNLinesOfFile(int n, File f) throws FileNotFoundException {
      Scanner scanner = new Scanner(f);
      int counter = 0;
      ListNode head = null;
      ListNode last = null;

      while (counter < n && scanner.hasNextLine()) {
          head = insert(head, scanner.next());
          if (head == null) {
              head = last;
          }
          counter++;
      }

      scanner.close();
      return head;
  }


    private static ListNode insert(ListNode p, Object obj) {
      ListNode temp = new ListNode(obj, null);

      if (p == null) {
         temp.setNext(temp);
      } else {
         temp.setNext(p.getNext());
         p.setNext(temp);
      }

      return temp;
   }

   public static ListNode countingOff(ListNode p, int count, int n) {
      print(p);

      for (int i = 0; i < n - 1; i++) {
         p = remove(p, count);
         print(p);
      }
      p.setNext(p.getNext().getNext());
      return p;
   }

   private static ListNode remove(ListNode p, int count) {
      for (int i = 0; i < count - 1; i++) {
         p = p.getNext();
      }

      p.setNext(p.getNext().getNext());
      return p;
   }

    public static void print(ListNode p) {
      if (p == null) {
          return;
      }

      ListNode current = p;

      while (current.getNext() != p ) {
          System.out.print(current.getNext().getValue() + " ");
          current = current.getNext();
      } 
      System.out.print(p.getValue());
      System.out.println("");
  }


   public static void replaceAt(ListNode p, Object obj, int pos) {
      for (int i = 0; i < pos; i++) {
         p = p.getNext();
      }
      p.setValue(obj);
   }
}
