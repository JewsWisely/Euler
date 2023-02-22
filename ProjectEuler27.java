public class ProjectEuler27
{
   public static void main(String[] args)
   {
      int amax = 0, bmax = 0, num = 0, nmax = 0;
      for(int a = -999; a < 1000; a++)
      {
         // System.out.println("a = " + a);
         for(int b = -1000; b <= 1000; b++)
         {
            while(isPrime(num * num + a * num + b))
            {
               num++;               
            }
            if(num > nmax)
            {
               nmax = num;
               amax = a;
               bmax = b;
               System.out.println(amax + " * " + bmax + " = " + amax * bmax + ", nmax = " + nmax);
            }
            num = 0;
         }
      }
      // System.out.println(amax + " * " + bmax + " = " + amax * bmax + ", nmax = " + nmax);
   }
   
   public static boolean isPrime(int num)
   {
      if(num < 2)
         return false;
      for(int i = 2; i < num / 2 + 1; i++)
         if(num % i == 0)
            return false;
      return true;
   }
}