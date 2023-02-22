import java.io.*;
import java.util.*;

public class ProjectEuler35
{
   public static void main(String[] args) throws Exception
   {
      long t0 = System.nanoTime();
      
      Scanner scanner = new Scanner(new File("primes.txt"));
      
      ArrayList<Integer> list = new ArrayList<Integer>();
      int num;
      
      while(true)
      {
         num = scanner.nextInt();
         if(num > 1000000)
            break;
         list.add(num);
      }
      
      HashSet<Integer> set = new HashSet<Integer>(list);
      //System.out.println("set size: " + set.size());
      
      int counter = 0;
      String str;
      boolean valid;
      for(int i = 0; i < list.size(); i++)
      {
         num = list.get(i);
         str = "" + num;
         valid = true;
         for(int k = 0; k < str.length() - 1; k++)
         {
            //System.out.println(str);
            str = str.substring(1, str.length()) + str.charAt(0);
            //System.out.println(str + "\n");
            if(!set.contains(Integer.parseInt(str)))
            {
               valid = false;
               break;
            }
         }
         if(valid)
         {
            //System.out.println(num);
            counter++;
         }
      }
      
      long t1 = System.nanoTime();
      
      System.out.println(counter + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
}