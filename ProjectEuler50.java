import euler.Primes;
import java.util.*;

public class ProjectEuler50
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      Primes p = new Primes(100000);
      int ans = -1, num, maxCount = -1;
      ArrayList<Integer> list = p.getList();
      
      for(int i = 0; i < list.size(); i++)
      {
         if(list.get(i) >= 500000)
            break;
         num = 0;
         for(int k = i; k < list.size(); k++)
         {
            num += list.get(k);
            if(num >= 1000000)
               break;
            if(p.isPrime(num) && k - i > maxCount)
            {
               maxCount = k - i;
               ans = num;
            }
         }
      }
      
      long t1 = System.nanoTime();
      System.out.println(ans + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
}