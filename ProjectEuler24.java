import static euler.Euler.permutations;

public class ProjectEuler24
{
   public static void main(String[] args)
   {
      long t0 = System.nanoTime();
      System.out.println(permutations("0123456789").get(999999) + ", " + (System.nanoTime() - t0)/1000000000.0 + " seconds");
   }
}