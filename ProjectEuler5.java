public class ProjectEuler5
{
   public static void main(String[] agrs)
   {
      long max = factorial(20);
      int[] big = {1, 1};
      for(int i = 0; i < max; i += 10)
      {
         if(highSeqDiv(i) > big[1])
         {
            big[1] = highSeqDiv(i);
            big[0] = i;
            System.out.println(i + ", " + big[1]);
         }
      }
   }
   public static long factorial(int x)
   {
      if(x == 0)
         return 1;
      else
         return (long)x * factorial(x - 1);
   }
   public static int highSeqDiv(int x)
   {
      for(int i = 1; i < x; i++)
      {
         if(x % i != 0)
            return i - 1;
      }
      return x;
   }
}