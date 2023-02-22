public class ProjectEuler23
{
   public static void main(String[] args)
   {
      boolean[] abundantSum = new boolean[28123];
      int sum = 0, divisorSum;
      for(int i = 1; i < abundantSum.length; i++)
      {
         divisorSum = 0;
         sum += i;
         for(int k = 1; k < i; k++)
         {
            if(i % k == 0)
               divisorSum += k;
         }
         if(divisorSum > i)
            abundantSum[i] = true;
      }
      for(int i = 0; i < abundantSum.length; i++)
      {
         for(int k = 0; k <= i; k++)
         {
            if(abundantSum[k] && abundantSum[i - k])
            {
               sum -= i;
               break;
            }
         }
      }
      System.out.println(sum);
   }
}