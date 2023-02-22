import static euler.Euler.*;
import java.util.*;

//after looking at thread, it became apparent that creating the set of triangle
//numbers is unnecessary since every triangle number is also a hexagonal number

public class ProjectEuler45
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      HashSet<Long> t = new HashSet<Long>();
      HashSet<Long> p = new HashSet<Long>();
      HashSet<Long> h = new HashSet<Long>();
      
      for(int i = 1; i < 60000; i++)
      {
         t.add((long)i * (i + 1) / 2);
         p.add((long)i * (3 * i - 1) / 2);
         h.add((long)i * (2 * i - 1));
      }
      
      t.retainAll(p);
      t.retainAll(h);
      
      ArrayList<Long> list = new ArrayList<Long>(t);
      Collections.sort(list);
      
      //System.out.println(list);
      
      long ans = list.get(2);
      
      long t1 = System.nanoTime();
      System.out.println(ans + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
}