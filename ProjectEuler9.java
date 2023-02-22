public class ProjectEuler9
{
   public static void main(String[] agrs)
   {
      double c;
      for(int a = 1; a < 1000; a++)
      {
         for(int b = 1; b < 1000; b++)
         {
            c = Math.sqrt(a * a + b * b);
            System.out.println(a + b + c);
            if(a + b + c == 1000)
            {
               System.out.println(a + " * " + b + " * " + c + " = " + a * b * c);
               return;
            }
         }
      }
   }
}