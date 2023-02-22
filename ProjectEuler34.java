public class ProjectEuler34
{
   public static void main(String[] args)
   {
      long t0 = System.nanoTime();
      int temp, sum, bigsum = 0;
      for(int i = 3; i < 100000; i++)
      {
         temp = i;
         sum = 0;
         while(temp != 0)
         {
            sum += f(temp % 10);
            temp /= 10;
         }
         if(sum == i)
            bigsum += i;
      }
      long t1 = System.nanoTime();
      System.out.printf("answer: %s, solve time: %ss", bigsum, (t1 - t0)/1000000000.0);
   }
   
   public static int f(int num)
   {
      return num <= 1 ? 1 : num * f(num - 1);
   }
}