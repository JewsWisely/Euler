import euler.Primes;
import static euler.Euler.*;
import java.util.*;

public class ProjectEuler49
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      Primes p = new Primes(2000);
      String ans = "", sp;
      int count;
      HashSet<ArrayList<String>> set = new HashSet<ArrayList<String>>();
      
      for(Integer prime : p.getList())
      {
         sp = "" + prime;
         
         if(sp.length() < 4)
            continue;
            
         else if(sp.length() > 4)
            break;
         
         ArrayList<String> perms = new ArrayList<String>(new TreeSet<String>(permutations(sp)));
         for(int i = perms.size() - 1; i >= 0; i--)
            if(!p.isPrime(integer(perms.get(i))))
               perms.remove(i);
         
         if(perms.size() > 2)
         {
            count = 0;
            for(int i = perms.size() - 2; i >= 0; i--)
               for(int k = perms.size() - 1; k > i; k--)
                  if(integer(perms.get(k)) - integer(perms.get(i)) == 3330 && ++count == 2)
                     set.add(perms);
         }
         
      }
      
      for(ArrayList<String> arr : set)
      {
         for(String str : arr)
            if(arr.contains(integer(str) + 3330 + "") || arr.contains(integer(str) - 3330 + ""))
               System.out.print(str);
         System.out.println();
      }
      
      long t1 = System.nanoTime();
      System.out.println("solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
}