public class ProjectEuler14
{
   public static void main(String[] args)
   {
      int number = 0, count = 1, result = 0;
      for(int num = 1; num <= 1000000; num++)
      {
         System.out.println(num);
         double temp = num;
         while(temp != 1)
         {
            count++;
            if(temp == 1)
               break;
            else if(temp % 2 == 0)
               temp /= 2;
            else
               temp = temp * 3 + 1;
         }
         //System.out.println(count);
         if(count > result)
         {
            number = num;
            result = count;
         }
         count = 1;
      }
      System.out.println(number + "\n" + result);
   }
}
//837799