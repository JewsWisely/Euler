public class ProjectEuler12
{
   public static void main(String[] agrs)
   {
      int x = 1, num = 1;
      while(countFactors(x) < 500)
         x += ++num;
   }
   public static int countFactors(int x)
   {
      int count = 0;
      for(int i = 1; i*i <= x; i++)
         if(x % i == 0)
         {
            count += 2;
            if(x / i == i)
               count--;
         }
      System.out.println(x + ": " + count);
      return count;
   }
}