import java.util.*;

public class ProjectEuler672
{
   static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
   
   public static void main(String[] args)
   {
      long t0 = System.nanoTime();
      
      for(int i = 1; i < 1000000; i++)
         map.put(i, g(i));
         
      System.out.println(h(10));
      
      long t1 = System.nanoTime();
      System.out.println("solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
   public static int g(int n)
   {
      //return n == 1 ? count : map.get(n) != null ? map.get(n) + count : n % 7 == 0 ? g(n / 7, count) : g(n + 1, count + 1);
      int count = 0;
      while(n != 1)
      {
         if(map.get(n) != null)
            return map.get(n) + count;
         else if(n % 7 == 0)
            n /= 7;
         else
         {
            n++;
            count++;
         }
      }
      return count;
   }
   
   public static int s(int n)
   {
      int sum = 0;
      for(int i = 1; i <= n; i++)
      {
         if(i % 100 == 0)
            System.out.println(100.0 * i / n);
         if(map.get(i) != null)
            sum += map.get(i);
         else
         {
            map.put(i, g(i));
            sum += map.get(i);
         }
      }
      return sum;
   }
   
   public static int h(int k)
   {
      return s((int)(Math.pow(7, k) - 1) / 11);
   }
}