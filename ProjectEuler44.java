import static euler.Euler.*;
import java.util.*;

public class ProjectEuler44
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      int min = -1, x, y;
      
      ArrayList<Integer> p = new ArrayList<Integer>();
      for(int i = 1; i < 10000; i++)
         p.add(i * (3 * i - 1) / 2);
         
      HashSet<Integer> set = new HashSet<Integer>(p);
         
      out:
      for(int i = 0; i < p.size(); i++)
      {
         x = p.get(i);
         for(int k = 0; k < i; k++)
         {
            y = p.get(k);
            
            if(!set.contains(x + y) || !set.contains(x - y))
               continue;
            
            min = x - y;
            System.out.printf("x = %s, y = %s, difference = %s\n", x, y, min);
            break out;
         }
      }
      
      long t1 = System.nanoTime();
      System.out.println(min + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
}