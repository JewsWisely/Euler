public class ProjectEuler10
{
   public static void main(String[] agrs)
   {
      long sum = 2;
      for(int i = 3; i < 2000000; i += 2)
         if(isPrime(i))
         {
            sum += i;
            System.out.println(i);
         }
      System.out.println(sum);
   }
   public static boolean isPrime(int x)
   {
      int count = 0;
      for(int i = 1; i < x / 2 + 1; i++)
         if(x % i == 0)
         {
            if(++count > 1)
               return false;
         }
      return true;
   }
}
//142,913,828,922