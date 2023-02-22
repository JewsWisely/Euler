import java.util.HashMap;

public class ProjectEuler39
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      for(int a = 1; a < 1001; a++)
      {
         for(int b = 1; b < a; b++)
         {
            double c = Math.sqrt(a * a + b * b);
            int p = a + b + (int)c;
            if(c * 10 % 10 == 0.0 && p < 1001)
            {
               map.put(p, map.get(p) == null ? 1 : map.get(p) + 1);
            }
         }
      }
      
      int max = -1, maxIndex = -1;
      
      for(Integer i : map.keySet())
      {
         if(map.get(i) > max)
         {
            max = map.get(i);
            maxIndex = i;
         }
      }
      
      long t1 = System.nanoTime();
      System.out.println(maxIndex + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
}