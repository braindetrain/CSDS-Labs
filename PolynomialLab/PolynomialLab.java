 // Name: Brian  
 // Date: 4/3/24

import java.util.*;

public class PolynomialLab
{
   public static void main(String[] args)
   {
      Polynomial poly = new Polynomial();    // 2x^3 + -4x + 2
      poly.makeTerm(1, -4);
      poly.makeTerm(3, 2);
      poly.makeTerm(0, 2);
      System.out.println("Map:  " + poly.getMap());
      System.out.println("String:  " + poly.toString());
      double evaluateAt = 2.0;
      System.out.println("Evaluated at "+ evaluateAt +": " +poly.evaluateAt(evaluateAt));
      
      System.out.println("-----------");
      Polynomial poly2 = new Polynomial();  // 2x^4 + x^2 + -5x + -3
      poly2.makeTerm(1, -5);
      poly2.makeTerm(4, 2);
      poly2.makeTerm(0, -3);
      poly2.makeTerm(2, 1);
      System.out.println("Map:  " + poly2.getMap()); 
      System.out.println("String:  " +poly2.toString());
      evaluateAt = -10.5;
      System.out.println("Evaluated at "+ evaluateAt +": " +poly2.evaluateAt(evaluateAt));  
      
      System.out.println("-----------");
      System.out.println("Sum: " + poly.add(poly2));
      System.out.println("Product:  " + poly.multiply(poly2));
      
   }
}

class Polynomial  
{
   private Map<Integer, Integer> poly;

   public Polynomial()
   {
      poly = new TreeMap<Integer, Integer>();
   }

   public void makeTerm(Integer exp, Integer coef)
   {
      poly.put(exp, coef);
   }
   
   public Map<Integer, Integer> getMap()
   {
      return poly;  
   }

   public double evaluateAt(double x)
   {
      double sum = 0;
      for (int i : poly.keySet())
        {
          sum += poly.get(i) * Math.pow(x, i);
        }
      return sum; 

   }
   
   public Polynomial add(Polynomial other)
   {
      Polynomial sum = new Polynomial();
      Map<Integer, Integer> polyMap = this.poly;
      Map<Integer, Integer> otherMap = other.poly;
     
     
      for (int i : polyMap.keySet())
        {
          int newCoef = polyMap.get(i);
          if (sum.poly.containsKey(i))
          {
            newCoef += sum.poly.get(i);
          }
          sum.makeTerm(i, newCoef);
        }
      for (int i : otherMap.keySet())
        {
          int newCoef = otherMap.get(i);
          if (sum.poly.containsKey(i))
          {
            newCoef += sum.poly.get(i);
          }
          sum.makeTerm(i, newCoef);
        }
      return sum;
      
   }
   
   public Polynomial multiply(Polynomial other)
   {
      Polynomial product = new Polynomial();
      Map<Integer, Integer> polyMap = this.poly;
      Map<Integer, Integer> otherMap = other.poly;

      for (int i : polyMap.keySet())
        {
          for (int j : otherMap.keySet())
            {
              int exp = i + j;
              int coef = polyMap.get(i) * otherMap.get(j);
              if (product.poly.containsKey(exp))
              {
                coef += product.poly.get(exp);
              }
              product.makeTerm(exp, coef);
            }
        }
      return product;
       
      
   }
   
   public String toString()
   {
      Set<Integer> st = poly.keySet();
      Iterator<Integer> iter= st.iterator();
      String s = "";
      while( iter.hasNext() )
      {
         Integer exp = iter.next();
         Integer coef = poly.get(exp);
         if( exp == 0 )           //constant term
            s = coef + "";
         else if( coef == 0 )     //0x
            s = s;
         else if( exp == 1 )        //x^1 term
         {
            if( coef == 1 )         // 1x^1
               s = "x + " + s;
            else
               s = coef + "x" + " + " + s;    //3x^1
         }
         else if( coef == 1 )      //1x
            s = "x^" + exp + " + " + s;
         else
            s = coef + "x^" + exp+ " + " + s;   //insert at the front.    
      }
      return s;
   }

}

/***************************************  
  ----jGRASP exec: java PolynomialLab
 Map:  {0=2, 1=-4, 3=2}
 String:  2x^3 + -4x + 2
 Evaluated at 2.0: 10.0
 -----------
 Map:  {0=-3, 1=-5, 2=1, 4=2}
 String:  2x^4 + x^2 + -5x + -3
 Evaluated at -10.5: 24469.875
 -----------
 Sum: 2x^4 + 2x^3 + x^2 + -9x + -1
 Product:  4x^7 + -6x^5 + -6x^4 + -10x^3 + 22x^2 + 2x + -6
 
  ----jGRASP: operation complete.
 ********************************************/
