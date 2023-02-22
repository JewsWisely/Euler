public class ProjectEuler6
{
   public static void main(String[] agrs)
   {
      int sumOfSquares = 0, squareOfSum = 0;
      for(int i = 1; i <= 100; i++)
      {
         sumOfSquares += i * i;
         squareOfSum += i;
      }
      squareOfSum *= squareOfSum;
      System.out.println(squareOfSum - sumOfSquares);
   }
}