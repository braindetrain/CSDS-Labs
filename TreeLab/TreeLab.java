// Name: Brian Tran
// Date: 04/18/2024

import java.util.*;

public class TreeLab
{
   public static String s = "XCOMPUTERSCIENCE";
   //public static String s = "XThomasJeffersonHighSchool"; 
   //public static String s = "XAComputerScienceTreeHasItsRootAtTheTop";
   //public static String s = "XA";   //comment out lines 43-45 below
   //public static String s = "XAF";  //comment out lines 43-45 below
   //public static String s = "XAFP";  //comment out lines 43-45 below
   //public static String s = "XDFZM";  //comment out lines 43-45 below 
   
   public static void main(String[] args)
   {
      TreeNode root = null;
      root = buildTree( s );
      System.out.print( display( root, 0) );
   
      System.out.print("\nPreorder: " + preorderTraverse(root));
      System.out.print("\nInorder: " + inorderTraverse(root));
      System.out.print("\nPostorder: " + postorderTraverse(root));
   
      System.out.println("\n\nNodes = " + countNodes(root));
      System.out.println("Leaves = " + countLeaves(root));
      System.out.println("Only children = " + countOnlys(root));
      System.out.println("Grandparents = " + countGrandParents(root));
   
      System.out.println("\nHeight of tree = " + height(root));
      System.out.println("Longest path = " + longestPath(root));
      System.out.println("Min = " + min(root));
      System.out.println("Max = " + max(root));	
   
      System.out.println("\nBy Level: ");
      System.out.println(displayLevelOrder(root));
   }
 
   public static TreeNode buildTree(String s)
   {
      TreeNode root = new TreeNode("" + s.charAt(1), null, null);
      for(int pos = 2; pos < s.length(); pos++)
         insert(root, "" + s.charAt(pos), pos, 
            (int)(1 + Math.log(pos) / Math.log(2)));
   
      insert(root, "A", 17, 5); 
      insert(root, "B", 18, 5); 
      insert(root, "C", 37, 6); //B's right child
      return root;
   }

   public static void insert(TreeNode t, String s, int pos, int level)
   {
      TreeNode p = t;
      for(int k = level - 2; k > 0; k--)
      {
         if((pos & (1 << k)) == 0)
            p = p.getLeft();
         else
            p = p.getRight();
      }
      if((pos & 1) == 0)
         p.setLeft(new TreeNode(s, null, null));
      else
         p.setRight(new TreeNode(s, null, null));
   }
   
   private static String display(TreeNode t, int level)
   {
      // turn your head towards left shoulder visualize tree
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
   
   public static String preorderTraverse(TreeNode t)
   { 
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";              //preorder visit
      toReturn += preorderTraverse(t.getLeft());   //recurse left
      toReturn += preorderTraverse(t.getRight());  //recurse right
      return toReturn;
   }
   
   public static String inorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if (t == null) {
         return "";
      }
    //recurse left
     toReturn += inorderTraverse(t.getLeft()); 
    //inorder visit
     toReturn += t.getValue() + " ";
    //recurse right
     toReturn += inorderTraverse(t.getRight());
     return toReturn;
   }
   
   public static String postorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if (t == null)
      {
         return "";
      }
      toReturn += postorderTraverse(t.getLeft());
      toReturn += postorderTraverse(t.getRight());
      toReturn += t.getValue() + " ";

      return toReturn;
   }
   
   public static int countNodes(TreeNode t)
   {
      if (t == null)
      {
         return 0;
      }
      return 1 + countNodes(t.getLeft()) + countNodes(t.getRight());
   }
   
   public static int countLeaves(TreeNode t)
   {
      if (t == null)
      {
         return 0;
      }
      if (t.getLeft() == null && t.getRight() == null)
      {
        return 1;
      }

      return countLeaves(t.getLeft()) + countLeaves(t.getRight());
   }
   
   /*  there are clever ways and hard ways to count grandparents  */ 
   public static int countGrandParents(TreeNode t)
   {
      if (t == null)
      {
         return 0;
      }
      
     int countLeft = countGrandParents(t.getLeft());
     int countRight = countGrandParents(t.getRight());

     boolean isLeftGrandParent = t.getLeft() != null && (t.getLeft().getLeft() != null || t.getLeft().getRight() != null);
     boolean isRightGrandParent = t.getRight() != null && (t.getRight().getLeft() != null || t.getRight().getRight() != null);

     if (isLeftGrandParent || isRightGrandParent)
     {
       return 1 + countLeft + countRight;
     }
      

      return countLeft + countRight;
   }
   
   public static int countOnlys(TreeNode t)
   {
      if (t == null)
      {
        return 0;
      }

      int countLeft = countOnlys(t.getLeft());
      int countRight = countOnlys(t.getRight());

      if (t.getLeft() == null && t.getRight() != null)
      {
        return 1 + countLeft + countRight;
      }

      if (t.getLeft() != null && t.getRight() == null)
      {
        return 1 + countLeft + countRight;
      }

      return countLeft + countRight;
   }
   
  /* returns the max of the heights to the left and the heights to the right  
     returns -1 in case the tree is null
    */
   public static int height(TreeNode t)
   {
      if (t == null)
      {
        return -1;
      }

      return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
   }
   
 /* return the max of the sum of the heights to the left and the heights to the right  
 */
   public static int longestPath(TreeNode t)
   {
      if (t == null)
      {
        return -1;
      }
     

      return 1 + Math.max(longestPath(t.getLeft()), longestPath(t.getRight()));
   }
   
   /*  Object must be cast to Comparable in order to call .compareTo  
    */
   @SuppressWarnings("unchecked")
   public static Object min(TreeNode t)
   {
      if(t == null)
         return null;
      Comparable left = (Comparable)min(t.getLeft());
      Comparable right = (Comparable)min(t.getRight());
      Object answer = t.getValue();
      if(left != null && left.compareTo(answer) < 0)
         answer = left;
      if(right != null && right.compareTo(answer) < 0)
         answer = right;
      return answer;
   }
   
   /*  Object must be cast to Comparable in order to call .compareTo  
    */
   @SuppressWarnings("unchecked")
   public static Object max(TreeNode t)
   {
      if (t == null)
      {
        return null;
      }
      
      Comparable left = (Comparable)max(t.getLeft());
      Comparable right = (Comparable)max(t.getRight());
      Object answer = t.getValue();
      if (left != null && left.compareTo(answer) > 0)
      {
        answer = left;
      }
      if (right != null && right.compareTo(answer) > 0)
      {
        answer = right;
      }
      return answer;
   }
      
   /* This method is not recursive.  Use a local queue
    * to store the children of the current TreeNode.
    */
   public static String displayLevelOrder(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      else
      {
         //instantiate a Queue of TreeNode as a LinkedList
         Queue<TreeNode> q = new LinkedList<TreeNode> ();
         //add t to the queue
         q.add(t);
         //while the queue is not empty
         while(!q.isEmpty())
           {
            //remove from the queue and assign it to a temp TreeNode variable
            TreeNode temp = q.remove(); 
            //if the temp has a left child
            if (temp.getLeft() != null)
            {
               //add it to the queue
               q.add(temp.getLeft());
            }
            //if the temp has a right child
            if (temp.getRight() != null)
            {
               //add it to the queue
                q.add(temp.getRight());
            }
            //modify toReturn by concatenating with the temp's value
            toReturn += temp.getValue() + " ";
           }
         toReturn += "\n";
      }
      return toReturn;
   }
}

/***************************************************
    ----jGRASP exec: java TreeLab
 		  	E
 		E
 			C
 	M
 			N
 		T
 			E
 C
 			I
 		U
 			C
 	O
 			S
 					C
 				B
 		P
 				A
 			R
 
 Preorder: C O P R A S B C U C I M T E N E C E 
 Inorder: R A P B C S O C U I C E T N M C E E 
 Postorder: A R C B S P C I U O E N T C E E M C 
 
 Nodes = 18
 Leaves = 8
 Only children = 3
 Grandparents = 5
 
 Height of tree = 5
 Longest path = 8
 Min = A
 Max = U
 
 By Level: 
 COMPUTERSCIENCEABC    
 *******************************************************/
