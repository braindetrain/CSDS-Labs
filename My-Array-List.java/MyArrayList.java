    //create your own version of the ArrayList by completing this class definition
	 //look in ListInterface to see what methods you need to create
    
    public class MyArrayList<anyType> implements ListInterface<anyType>
   {
      private Object[] list;		//stores the actual elements
      private int numElements;	//used to keep track of the number of valid elements in the list
      private static final int initialCapacity = 10;
   	
       public MyArrayList()
      {
         list = new Object[initialCapacity];	//start with a buffer size of 10
         numElements = 0;
      }
   
       private void doubleCapacity()	//private because this is a helper method that need not be used outside of the class
      {
        //make list twice as big if element is added over the capacity of list 
      	int newCapacity = list.length * 2;
        Object[] newList = new Object[newCapacity];
        //copy all the elements from the old list to the new list
        for (int i = 0; i < list.length; i++)
          {
            newList[i] = list[i];
          }
        list = newList;
      }
      
       private void cutCapacity()	//private because this is a helper method that need not be used outside of the class
      {
      	//make list half as big, i.e. given [A, B, C, null, null, null, null, null], results with [A, B, C, null]
      	//to be used if after removing an element, we have less than 1/3 of the capacity of list being used
        int newCapacity = Math.max(initialCapacity, list.length / 2);
        Object[] newList = new Object[newCapacity];
        //copy all the elements from the old list to the new list
        for (int i = 0; i < numElements; i++)
          {
            newList[i] = list[i];
          }
        list = newList;
      }

      public boolean add(anyType element)
     {
       //cannot add element if element is null
       if (element == null)
       {
         return false;
       }

       //make space for the element if there is not enough space
       if (numElements == list.length)
       {
         doubleCapacity();
       }
       //add the element to the end of the list
       list[numElements] = element;
       numElements++;
       return true;
     }

     public boolean add(int index, anyType element)
     {
       //cannot add element if element is null or the index is greater or less than the number of elements 
       if (index < 0 || index > numElements || element == null)
       {
         return false;
       }
        //make space for the element if there is not enough space 
        if (numElements == list.length)
        {
          doubleCapacity();
        }
       //move all the elements to the right of the index to the right by one space 
       for (int i = numElements - 1; i >= index; i--)
         {
           list[i + 1] = list[i];
         }
      //add the element to the correct index
       list[index] = element;
       numElements++;
       return true;
     }

     public anyType remove(int index)
     {
       //cannot remove element if the index is greater or less than the number of elements
       if (index < 0 || index >= numElements)
       {
         return null;
       }
       //save the element to be removed
       anyType removedElement = (anyType) list[index];
       //move all the elements to the left of the index to the left by one space
       for (int i = index; i < numElements - 1; i++)
         {
           list[i] = list[i + 1];
         }
       numElements--;
       //fix array size if applicable 
       if (numElements < list.length / 3)
         cutCapacity();
       return removedElement; 
     }

     //the number of elements in the array keeps track of the size of the array
      public int size()
     {
       return numElements;
     }

     public anyType set(int index, anyType element)
     {
       //cannot set element if the index is greater or less than the number of elements or element is null
       if (index < 0 || index >= numElements || element == null)
       {
         return null;
       }
       //save the element to be replaced
       anyType temp = (anyType) list[index];
       list[index] = element;
       return temp; 
     }

     public anyType get(int index)
     {
       //cannot get element if the index is greater or less than the number of elements
       if (index < 0 || index >= numElements)
       {
         return null;
       }
       //return the element at the index
       return (anyType) list[index];
     }
     
     
      
       public String toString()
      {
        if (numElements == 0)
        {
          return "[]";
        }

         String ans = "[" + list[0];
      	//add all array elements with a comma separating each, i.e. [A, B, C] 
        for (int i = 1; i < numElements; i++)
          {
            ans += ", " + list[i];
          }
         return ans + "]";
      }
      
   }
