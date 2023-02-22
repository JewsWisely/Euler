import static euler.Euler.*;
import java.util.ArrayList;

public class ProjectEuler41
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      ArrayList<Integer> primes = getPrimes(1000000);
      int max = 0;
      
      for(int i = 0; i < primes.size(); i++)
      {
         for(int k = 9; k >= 1; k--)
            if(isPandigital(primes.get(i), k))
            {
               //System.out.println(primes.get(i));
               max = primes.get(i);
               break;
            }
      }
      
      long t1 = System.nanoTime();
      System.out.println(max + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
}