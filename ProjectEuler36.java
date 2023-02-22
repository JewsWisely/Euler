import static euler.Euler.*;

public class ProjectEuler36
{
   public static void main(String[] args)
   {
      long t0 = System.nanoTime();
      int sum = 0;
      for(int i = 0; i < 1000000; i++)
      {
         //System.out.println(i + ", " + isPalindrome("" + i));
         if(isPalindrome("" + i) && isPalindrome("" + binary(i)))
            sum += i;
      }
      long t1 = System.nanoTime();
      System.out.println(sum + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
}