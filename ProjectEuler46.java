import static euler.Euler.*;
import java.util.*;

public class ProjectEuler46
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      int ans = -1;
      
      ArrayList<Integer> primes = getPrimes(10000);
      HashSet<Integer> pset = new HashSet<Integer>(primes);
      HashSet<Integer> set = new HashSet<Integer>();
      
      for(int i = 0; i < 1000; i++)
      {
         for(int k = 0; k < 50; k++)
         {
            set.add(primes.get(i) + 2 * k * k);
         }
      }
      
      for(int i = 3; i < 1000000; i += 2)
      {
         if(!pset.contains(i) && !set.contains(i))
         {
            ans = i;
            System.out.println(i);
            break;
         }
      }
      
      
      long t1 = System.nanoTime();
      System.out.println(ans + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
}