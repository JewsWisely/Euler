import java.math.BigDecimal;
import java.util.*;

public class ProjectEuler26
{
   public static void main(String[] args)
   {
      long t0 = System.currentTimeMillis();
      int max = 0, num = 0, len;
      for(int i = 2; i < 1000; i++)
      {
         len = patternLength(BigDecimal.ONE.divide(BigDecimal.valueOf(i), 10001, BigDecimal.ROUND_HALF_UP));
         //System.out.println(i + ": " + len);
         if(len > num)
         {
            num = len;
            max = i;
         }
      }
      long t1 = System.currentTimeMillis();
      System.out.println(max + ", solve time: " + (t1 - t0) + "ms");
   }
   
   public static int patternLength(BigDecimal num)
   {
      String str = num.toString();
      str = str.substring(2, str.length() - 1);
      //System.out.println(str);
      //System.out.println(str.length());
      for(int i = 1; i <= str.length() / 2; i++)
         if(str.substring(str.length() - i).equals(str.substring(str.length() - 2 * i, str.length() - i)) && str.split(str.substring(str.length() - i)).length <= 1)
            return i;
      return 0;
   }
}