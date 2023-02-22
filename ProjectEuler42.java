import java.util.*;
import java.io.*;

public class ProjectEuler42
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      HashSet<Integer> set = new HashSet<Integer>();
      for(int i = 1; i < 500; i++)
         set.add(i*(i+1)/2); 
      
      Scanner scanner = null;
      try
      {
         scanner = new Scanner(new File("text/42.txt"));
      }
      catch(Exception e)
      {
         System.out.println("ERROR!");
      }
      
      int count = 0, value;
      String alphabet = "_ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      
      for(String str : scanner.next().split(","))
      {
         value = 0;
         for(int i = 1; i < str.length() - 1; i++)
            value += alphabet.indexOf("" + str.charAt(i));
         if(set.contains(value))
            count++;
            //System.out.println(str);
      }
      
      long t1 = System.nanoTime();
      System.out.println(count + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
}