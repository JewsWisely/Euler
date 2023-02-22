public class ProjectEuler7
{
   public static void main(String[] agrs)
   {
      int count = 0, i = 2;
      while(count < 10001)
      {
         if(isPrime(i))
         {
            count++;
            System.out.println(count + ": " + i); 
         }
         i++;
      } 
   }
   public static boolean isPrime(int num)
   {
      int count = 0;
      for(int i = 1; i <= num / 2; i++)
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