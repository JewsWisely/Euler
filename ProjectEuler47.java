import euler.Primes;
import java.util.*;

public class ProjectEuler47
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      Primes p = new Primes(100000);
      
      int ans = -1, found = 0, inARow = 4;
      
      for(int i = 647; i < 1000000; i++)
      {
         if(found == inARow)
         {
            ans = i - inARow;
            break;
         }
         else if(p.primeDivisors(i).size() == inARow)
            found++;
         else
            found = 0;
      }
      
      long t1 = System.nanoTime();
      System.out.println(ans + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
}