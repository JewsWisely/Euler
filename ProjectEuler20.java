import java.math.*;

public class ProjectEuler20
{
   public static void main(String[] args)
   {
      BigInteger num = fact(3673);
      System.out.println(num);
      int digits = digits(num);
      System.out.print("digits: " + digits + "\nsum of digits: " + sum(num, digits));
   }
   
   public static BigInteger fact(int num)
   {
      if(num <= 1)
         return new BigInteger("1");
      return new BigInteger(num + "").multiply(fact(num - 1));
   }
   
   public static int digits(BigInteger num)
   {
      if(num.equals(BigInteger.ZERO))
         return 0;
      return 1 + digits(num.divide(BigInteger.TEN));
   }
   
   public static int sum(BigInteger num, int digits)
   {
      if(digits == 1)
         return num.intValue();
      return num.remainder(BigInteger.TEN).intValue() + sum(num.divide(BigInteger.TEN), digits - 1);
   }
}