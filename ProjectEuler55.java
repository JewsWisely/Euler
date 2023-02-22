import static euler.Euler.*;
import java.math.BigInteger;

public class ProjectEuler55
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      int count = 0;
      for(int i = 5; i < 10000; i++)
         if(isLychrel(new BigInteger(i + "")))
            count++;
      
      long t1 = System.nanoTime();
      System.out.println(count + ", solve time: " + (t1 - t0)/1000000.0 + " milliseconds");
   }
   
   public static BigInteger addReverse(BigInteger num)
   {
      return num.add(new BigInteger(reverse("" + num)));
   }
   
   public static boolean isLychrel(BigInteger num)
   {
      for(int k = 0; k < 50; k++)
         if(isPalindrome((num = addReverse(num)) + ""))
            return false;
      return true;
   }
   
}