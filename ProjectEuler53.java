import static euler.Euler.*;
import java.util.*;

public class ProjectEuler53
{     
   static HashMap<Integer, Double> map = new HashMap<Integer, Double>();
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      for(int i = 1; i <= 100; i++)
         map.put(i, factorial(i));
      
      int count = 0;
      for(int i = 23; i <= 100; i++)
         for(int k = 3; k < i; k++)
            if(ncr(i, k) >= 1000000)
               count++;
      System.out.println(count);
      
      long t1 = System.nanoTime();
      System.out.println("solve time: " + (t1 - t0)/1000000.0 + " milliseconds");
   }
   
   public static int ncr(int n, int r)
   {
      return (int)(map.get(n) / (map.get(r) * map.get(n - r)));
   }
}