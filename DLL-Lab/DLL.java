// Name: Brian Tran
// Date: 1/31/2024

//  implements some of the List and LinkedList interfaces: 
//	 	  size(), add(i, o), remove(i);  addFirst(o), addLast(o); 
//  This class also overrides toString().
//  the list is zero-indexed.
//  Uses DLNode.

public class DLL        //DoubleLinkedList
{
   private int size;
   private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
  public int size()
  {
    /* enter your code  */
    return size;
  }
   
  /* appends obj to end of list; increases size;
  	  @return true  */
  public boolean add(Object obj)
  {
    addLast(obj);
    return true;   
  }
   
   /* inserts obj at position index.  increments size. 	*/
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
  {
    if( index > size || index < 0 )
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
    DLNode newNode = new DLNode(obj, null, null);
    DLNode current = head;

    for (int i = 0; i < index; i++)
      {
        current = current.getNext();
      }

    newNode.setNext(current.getNext());
    newNode.setPrev(current);
    current.getNext().setPrev(newNode);
    current.setNext(newNode);
    size++;         
  }
   
  /* return obj at position index. 	*/
  public Object get(int index)
  { 
    if(index >= size || index < 0)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
    DLNode current = head.getNext(); 
    for (int i = 0; i < index; i++)
      {
        current = current.getNext();
      }

    return current.getValue();
  }
   
  /* replaces obj at position index. 
      returns the obj that was replaced*/
  public Object set(int index, Object obj)
  {
    if(index >= size || index < 0)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
    DLNode current = head.getNext();
    for (int i = 0; i < index; i++)
      {
        current = current.getNext();
      }
    Object old = current.getValue();
    current.setValue(obj);
    return old;
  }
   
  /*  removes the node from position index (zero-indexed).  decrements size.
      @return the object of the node that was removed.    */
  public Object remove(int index)
  {
    if(index >= size || index < 0)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
    DLNode current = head.getNext();
    for (int i = 0; i < index; i++)
      {
        current = current.getNext();
      }

    current.getPrev().setNext(current.getNext());
    current.getNext().setPrev(current.getPrev());
    size--;

    return current.getValue();
   }
   
  /* inserts obj at front of list, increases size   */
  public void addFirst(Object obj)
  {
    /* enter your code below  */
    DLNode newNode = new DLNode(obj, null, null);
    newNode.setNext(head.getNext());
    newNode.setPrev(head);
    head.getNext().setPrev(newNode);
    head.setNext(newNode);
    size++;
  }
   
  /* appends obj to end of list, increases size    */
  public void addLast(Object obj)
  {
    /* enter your code below  */
    DLNode newNode = new DLNode(obj, null, null);
    newNode.setPrev(head.getPrev());
    newNode.setNext(head);
    head.getPrev().setNext(newNode);
    head.setPrev(newNode);
    size++;
  }
   
  /* returns the first element in this list  */
  public Object getFirst()
  {
     return head.getNext().getValue();
  }
   
  /* returns the last element in this list  */
  public Object getLast()
  {
     
    return head.getPrev().getValue();
  }
   
  /* returns and removes the first element in this list, or
     returns null if the list is empty  */
  public Object removeFirst()
  {
     DLNode firstNode = head.getNext();
    head.setNext(firstNode.getNext());
    firstNode.getNext().setPrev(head);
    size--;

    return firstNode.getValue();
  }
   
  /* returns and removes the last element in this list, or
       returns null if the list is empty  */
  public Object removeLast()
  {
     DLNode lastNode = head.getPrev();
    head.setPrev(lastNode.getPrev());
    lastNode.getPrev().setNext(head);
    size--;
    
    return lastNode.getValue();
  }
   
  /*  returns a String with the values in the list in a 
      friendly format, for example   [Apple, Banana, Cucumber]
      The values are enclosed in [], separated by one comma and one space.
  */
  public String toString()
  {
    String ret = "";
    /* enter your code  */
    DLNode current = head.getNext();
    for (int i = 0; i < size; i++)
      {
        ret += current.getValue();
        if (i < size - 1)
        {
          ret += ", ";
        }
        current = current.getNext();
      }
    ret += "]";
    return ret;
  }
}
