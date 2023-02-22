public class ProjectEuler21
{
   public static void main(String[] args)
   {
      int[] nums = new int[10001];
      int sum = 0;
      for(int i = 1; i <= 10000; i++)
      {
         nums[i] = factorSum(i);
         if(nums[i] <= 10000 && i == nums[nums[i]] && i != nums[i])
            sum+= i + nums[i];
      }
      System.out.println(sum);
   }
   
   public static int factorSum(int num)
   {
      int count = 1;
      for(int i = 2; i < num; i++)
         if(num % i == 0)
            count += i;
      return count;
   }
}