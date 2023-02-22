import java.math.*;

public class ProjectEuler25
{
   public static void main(String[] args)
   {
      BigDecimal num = BigDecimal.ONE, one = BigDecimal.ZERO, two = BigDecimal.ONE;
      int count = 2;
      
      while(num.toString().length() < 1000)
      {
         num = f(one, two);
         one = two;
         two = num;
         System.out.printf("%s %s\n", count++, num.toString().length());
      }
   }
   
   public static BigDecimal f(BigDecimal one, BigDecimal two)
   {
      return one.add(two);
   }
}