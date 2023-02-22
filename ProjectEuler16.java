import java.util.ArrayList;

public class ProjectEuler16
{
   public static void main(String[] args)
   {
      ArrayList<Integer> digits = new ArrayList<Integer>();
      digits.add(1);
      int pow = 1000;
      long time1 = System.nanoTime();
      for(int i = 0; i < pow; i++)
      {
         digits = multiplyByTwo(digits);
      }
      long time2 = System.nanoTime();
      System.out.print("2^" + pow + " = ");
      for(int i = 0; i < digits.size(); i++)
         System.out.print(digits.get(i));
      System.out.println();
      int sum = 0;
      for(int i = 0; i < digits.size(); i++)
         sum += digits.get(i);
      System.out.println("sum of the digits = " + sum);
      System.out.println((time2 - time1) / 1000000 + "ms to compute 2^" + pow);
   }
   
   public static ArrayList<Integer> multiplyByTwo(ArrayList<Integer> num)
   {
      for(int i = 0; i < num.size(); i++)
      {
         num.set(i, num.get(i) * 2);
         if(num.get(i) >= 10 && i != 0)
         {
            num.set(i - 1, num.get(i - 1) + 1);
            num.set(i, num.get(i) % 10);
         }
         if(num.get(i) >= 10 && i == 0)
         {
            num.add(i + 1, num.get(i) % 10);
            num.set(i, 1);
            i++;
         }
      }
      return num;
   }
}