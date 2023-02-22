public class ProjectEuler3
{
   public static void main(String[] agrs)
   {
      long num = 600851475143L, divisor = 1;
      while(divisor <= num / 2 + 1)
      {
         if(num % divisor == 0)
         {
            System.out.println(num + " / " + divisor + " = " + num / divisor);
            if(isPrime(num / divisor))
            {
               System.out.println("The winner is: " + num / divisor);
               break;
            }
         }
         divisor += 2;
      }
   }
   public static boolean isPrime(long num)
   {
      int count = 0;
      for(long i = 2; i < num / 2 + 1; i++)
      {
         if(num % i == 0)
         {
            count++;
            if(count > 1)
               return false;
         }
      }
      return true;
   }
}