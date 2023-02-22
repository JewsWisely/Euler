public class ProjectEuler2
{
   public static void main(String[] agrs)
   {
      int first = 1, second = 2, sum = 0;
      while(second < 4000000)
      {
         if(second % 2 == 0)
            sum += second;
         int temp = second;
         second += first;
         first = temp;
      }
      System.out.println(sum);
   }
}
