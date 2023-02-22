import static euler.Euler.*;
import java.util.*;

public class ProjectEuler52
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      int num = 0;
      String str;
      ree:
      while(true)
      {
         num++;
         str = "" + num;
         for(int i = 2; i <= 6; i++)
         {
            if(!isPermutation(str, num * i + ""))
               continue ree;
         }
         System.out.println(num);
         break;
      }
      
      long t1 = System.nanoTime();
      System.out.println("solve time: " + (t1 - t0)/1000000.0 + " ms");
   }
   
   public static boolean isPermutation(String s1, String s2)
   {
      if(s1.length() != s2.length())
         return false;
      StringBuilder bob = new StringBuilder(s1);
      int index;
      for(int i = 0; i < s2.length(); i++)
      {
         index = bob.indexOf(s2.substring(i, i + 1));
         if(index == -1)
            return false;
         else
            bob.deleteCharAt(index);
      }
      return true;
   }
}