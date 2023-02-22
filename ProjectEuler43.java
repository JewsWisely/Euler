import static euler.Euler.permutations;

public class ProjectEuler43
{
   //static int[] primes = {2, 3, 5, 7, 11, 13, 17};
      
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      //took  14 minutes 15 seconds
      
      long sum = 0;
      
      /*
      for(long i = 1023456789l; i < 9876543211l; i++)
      {
         if(!isPandigital("" + i, 0, 9) || !isValid("" + i))
            continue;
         
         sum += i;
         System.out.println(i);
      }*/
      
      //took around 3.2 seconds
      
      for(String s : permutations("0123456789"))
      {
         if(!isValid(s))
            continue;
         
         sum += Long.parseLong(s);
         System.out.println(s);
      }
      
      long t1 = System.nanoTime();
      System.out.println(sum + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
   public static boolean isValid(String str)
   {
      for(int k = 0; k < primes.length; k++)
         if(Integer.parseInt(str.substring(k + 1, k + 4)) % primes[k] != 0)
            return false;
      return true;
   }
   
   public static boolean isPandigital(String str, int min, int max)
   {
      for(int i = min; i <= max; i++)
      {
         if(str.indexOf("" + i) != -1)
            continue;
         return false;
      }
      return true;
   }
   
   
   
}