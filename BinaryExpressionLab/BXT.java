// Name: Brian Tran  
// Date:  4/22/24
/*  Represents a binary expression tree.
 *  The BXT builds itself from postorder expressions. It can
 *  evaluate and print itself.  Also prints inorder and postorder strings. 
 */
 
import java.util.*;

public class BXT
{
   private TreeNode root;   
   
   public BXT()
   {
      root = null;
   }
  public TreeNode getRoot()  
  {
    return root;
  }
    
   public void buildTree(String str) // not recursive
   {
      String[] treeStrings = str.split(" ");
      Stack<TreeNode> treeNodes = new Stack<TreeNode>();
      for (String s : treeStrings)
        {
          if (isOperator(s))
          {
            TreeNode right = treeNodes.pop();
            TreeNode left = treeNodes.pop();
            TreeNode node = new TreeNode(s, left, right);
            treeNodes.push(node);
          }
          else
          {
            TreeNode node = new TreeNode(s);
            treeNodes.push(node);
          }
        }
      root = treeNodes.pop();
     
   }
   
   public double evaluateTree()
   {
      return evaluateNode(root);
   }
   
   private double evaluateNode(TreeNode t)  //recursive
   {
     //declare variables (but don’t assign anything to them yet) for result, left, and right (doubles) and the value of the parameter node (String)
     double result = 0;
     double left = 0;
     double right = 0;
     String value = t.getValue() + ""; 
     //-is the parameter null? assign 0 to result
     if (t == null)
     {
       result = 0;
     }

     else
     {
       if (isOperator(value))
       {
         left = evaluateNode(t.getLeft());
         right = evaluateNode(t.getRight());
         result = computeTerm(value, left, right);
       }
       else
       {
         result = Double.parseDouble(value);
       }
     }
      return result;
   }
   
   private double computeTerm(String s, double a, double b)
   {
      if (s.equals("+"))
      {
        return a + b;
      }

     if (s.equals("-"))
     {
       return a - b;
     }

     if (s.equals("*"))
     {
       return a * b;
     }

     if (s.equals("/"))
     {
       return a / b;
     }

     return 0;
     
   }
   
   private boolean isOperator(String s)
   {
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
      {
        return true;
      }
      return false;
    
   }
   
   public String display()
   {
      return display(root, 0);
   }
   
   private String display(TreeNode t, int level)
   {
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
    
   public String inorderTraverse()
   {
      return inorderTraverse(root);
   }
   
   private  String inorderTraverse(TreeNode t)
   {
      String toRet = "";
      if (t == null)
      {
        return "";
      }
      toRet += inorderTraverse(t.getLeft());
      toRet += t.getValue() + " ";
      toRet += inorderTraverse(t.getRight());
      return toRet;
     
   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);
   }
   
   private String preorderTraverse(TreeNode root)
   {
     String toRet = "";
     if (root == null)
     {
       return "";
     }
     toRet += root.getValue() + " ";
     toRet += preorderTraverse(root.getLeft());
     toRet += preorderTraverse(root.getRight());
     return toRet;
   }
}
