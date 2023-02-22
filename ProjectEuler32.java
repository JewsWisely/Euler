import java.util.HashSet;

public class ProjectEuler32
{
   public static String str;
   public static void main(String[] args)
   {
      long t0 = System.currentTimeMillis();
      
      HashSet<Integer> set = new HashSet<Integer>();
      
      for(int i = 12; i <= 98; i++)
         for(int k = 123; k < 987; k++)
            set.add(product(i, k));
      
      for(int i = 2; i <= 9; i++)
         for(int k = 1234; k <= 9876; k++)
            set.add(product(i, k));
      
      int sum = 0;
      
      for(Integer i : set)
         sum += i;
      
      long t1 = System.currentTimeMillis();
      System.out.println(sum + " solve time: " + (t1 - t0) + "ms");
   }
   
   public static int product(int i, int k)
   {
      str = "" + i + k + (i * k);
         
      if(str.indexOf("0") != -1)
         return 0;
               
      for(int f = 1; f <= 9; f++)
         if(str.indexOf("" + f) == -1 || str.indexOf("" + f) != str.lastIndexOf("" + f))
            return 0;
      
      return i * k;
   }
}