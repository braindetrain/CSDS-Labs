//Name: Brian Tran  
//Date: 4/24/24

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   public void addBalanced(String obj);
   public boolean remove(String obj);
   public String min();
   public String max();
   public String toString();
}

/*******************
Represents a binary search tree holding Strings. 
Implements (most of) BSTinterface, above. 
The recursive methods all have a public method calling a private helper method. 
Copy the display() method from TreeLab. 
**********************/
class BST implements BSTinterface
{
   private TreeNode root;
   private int size;
  
   public BST()
   {
      root = null;
      size = 0;
   }
  
   public int size()
   {
      return size;
   }
  
   public TreeNode getRoot() 
   {
     return root;
   }
   /***************************************
   @param s -- one string to be inserted
   ****************************************/
   public void add(String s) 
   {
      root = add(root, s);
   }
   private TreeNode add(TreeNode t, String s) // helper method
   {      
      if (t == null)
      {
         t = new TreeNode(s);
         size++;
      }
        
      else if (s.compareTo(t.getValue().toString()) < 0)
      {
         t.setLeft(add(t.getLeft(), s));
      }
        
      else if (s.compareTo(t.getValue().toString()) > 0)
      {
        t.setRight(add(t.getRight(), s));
      }
        
      else
      {
         t.setLeft(add(t.getLeft(), s));
      }
      return t;
   }
   
   public String display()
   {
      return display(root, 0);
      
   }
   private String display(TreeNode t, int level) // helper method
   {
     String toRet = "";
     if (t == null)
     {
       return "";
     }

     toRet += display(t.getRight(), level + 1);
     for (int k  = 0; k < level; k++)
       {
         toRet += "\t";
       }
     toRet += t.getValue().toString() + "\n";
     toRet += display(t.getLeft(), level + 1);
     return toRet;
   }
   
   public boolean contains( String obj)
   {
      return contains(root, obj);
      
   }
   private boolean contains(TreeNode t, String x) // helper method
   {
    if (t == null)
    {
      return false;
    }

     else if (x.compareTo(t.getValue().toString()) < 0)
     {
       return contains(t.getLeft(), x);
     }

     else if (x.compareTo(t.getValue().toString()) > 0)
     {
       return contains(t.getRight(), x);
     }

     else
     {
       return true;
     }
   
   }
   
   public String min()
   {
      return min(root);
   }
  
   private String min(TreeNode t)  //helper method - use iteration
   {
     if (t == null)
        {
          return "";
        }

    while (t.getLeft() != null)
      {
        t = t.getLeft();
      }
    return t.getValue().toString();
   }
   
   public String max()
   {
      return max(root);
      
   }
   private String max(TreeNode t)  //helper method - use recursion
   {
     if (t == null)
     {
       return "";
     }

     while (t.getRight() != null)
       {
         t = t.getRight();
       }
     return t.getValue().toString();
   }
   
   public String toString()
   {
      return toString(root);
   }
   private String toString(TreeNode t)  //an in-order traversal.  Use recursion.
   {
     String toRet = "";
     if (t == null)
     {
       return "";
     }
     toRet += toString(t.getLeft());
     toRet += t.getValue().toString() + " ";
     toRet += toString(t.getRight());
     return toRet;
   }

   public boolean remove(String obj)
  {
    root = remove(root, obj);
    return true;
  }

  private TreeNode remove(TreeNode current, String obj)
  {
    if (current == null)
    {
      return null;
    }

    if (obj.compareTo(current.getValue().toString()) < 0)
    {
      current.setLeft(remove(current.getLeft(), obj));
    }

    else if (obj.compareTo(current.getValue().toString()) > 0)
    {
      current.setRight(remove(current.getRight(), obj));
    }

    else
    {
      if (current.getLeft() == null)
      {
        return current.getRight();
      }

      else if (current.getRight() == null)
      {
        return current.getLeft();
      }

      current.setValue(min(current.getRight()));
      current.setRight(remove(current.getRight(), current.getValue().toString()));
    }
    return current;
  }

  public void addBalanced(String obj)
  {
    root = addBalanced(root, obj);
  }

  private TreeNode addBalanced(TreeNode current, String obj)
  {
    if (current == null)
    {
      return new TreeNode(obj);
    }

    if (obj.compareTo(current.getValue().toString()) < 0)
    {
      current.setLeft(addBalanced(current.getLeft(), obj));
    }

    else if (obj.compareTo(current.getValue().toString()) > 0)
    {
      current.setRight(addBalanced(current.getRight(), obj));
    }

    else
    {
      current.setValue(obj);
    }
    return current;
  }

  
}
