import euler.Primes;
import static euler.Euler.*;
import java.util.*;

public class ProjectEuler51
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      Primes p = new Primes(5, 80000);
      int start;
      ArrayList<TreeSet<String>> masks = new ArrayList<TreeSet<String>>();
      for(int i = 2; i < Math.pow(2, ("" + p.getList().get(p.size() - 1)).length()); i *= 2)
      {
         masks.add(new TreeSet<String>());
         start = (int)Math.pow(2, ("" + binary(i)).length() - 1);
         for(int k = start; k < start * 2 - 1; k++)
         {
            masks.get(masks.size() - 1).add(binary(k));
            masks.get(masks.size() - 1).add(reverse(binary(k)));
         }
      }
      //for(TreeSet<String> set : masks)
        // System.out.println(set);
      
      int len, count;
      StringBuilder bob;
      String sPrime;
      
      ree:
      for(Integer prime : p.getList())
      {
         sPrime = "" + prime;
         len = sPrime.length();
         if(len < 2)
            continue;
         //System.out.println(sPrime);
         //System.out.printf("%s, %s\n", prime, masks.get(len - 2));
         for(String pattern : masks.get(len - 2))
         {
            count = 0;
            for(int i = pattern.charAt(0) == '0' ? 1 : 0; i < 10; i++)
            {
               //System.out.print(prime + " + " + pattern + " + " + i + " = ");
               bob = new StringBuilder();
               for(int k = 0; k < len; k++)
               {
                  bob.append(pattern.charAt(k) == '1' ? sPrime.substring(k, k + 1) : i);
               }
               //System.out.println(bob.toString());
               if(p.isPrime(integer(bob.toString())))
                  count++;
            }
            //System.out.println(count + "\n");
            if(count == 8)
            {
               System.out.printf("prime: %s\npattern: %s\ncount: %s\n\n", prime, pattern, count);
               break ree;
            }
         }
      }
      
      long t1 = System.nanoTime();
      System.out.println("solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
   public static String reverse(String str)
   {
      return (new StringBuilder(str)).reverse().toString();
   }
}