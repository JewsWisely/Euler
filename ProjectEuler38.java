import static euler.Euler.*;

public class ProjectEuler38
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      String cat;
      int max = 0, bleh;
      for(int i = 1; i < 10000; i++)
      {
         cat = "";
         for(int k = 1; k <= 9; k++)
         {
            cat += i * k;
            if(isPandigital(cat))
            {
               bleh = Integer.parseInt(cat);
               if(bleh > max)
                  max = bleh;
               break;
            }
         }
      }
      long t1 = System.nanoTime();
      System.out.println(max + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
}