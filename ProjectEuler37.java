import static euler.Euler.*;
import static euler.Primes.*;
import java.util.ArrayList;
import java.util.HashSet;


public class ProjectEuler37
{
   public static void main(String[] args)
   {
      long t0 = System.nanoTime();
      
      ArrayList<Integer> list = getPrimes(100000);
      HashSet<Integer> set = new HashSet<Integer>(list);
      System.out.println(list.get(0) + " -> " + list.get(list.size()-1) + ", size = " + list.size());
      
      String str;
      int len, sum = 0, i, count = 0;
      boolean valid;
      for(int r = 0; r < list.size(); r++)
      {
         if(r < 4)
            continue;
         i = list.get(r);
         str = "" + i;
         len = str.length();
         valid = true;
         for(int k = 1; k < len; k++)
         {
            if(!set.contains(Integer.parseInt(str.substring(0, len - k))) || !set.contains(Integer.parseInt(str.substring(k))))
            {
               valid = false;
               break;
            }
         } 
         if(valid)
            sum += i;
      }
      
      long t1 = System.nanoTime();
      System.out.println(sum + ", " + (t1 - t0)/1000000000.0 + " seconds");
   }
}