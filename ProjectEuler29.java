import java.util.HashSet;
import java.math.BigInteger;

public class ProjectEuler29
{
   public static void main(String[] args){
      long t0 = System.nanoTime();
      HashSet<BigInteger> set = new HashSet<BigInteger>();
      for(int x = 2; x <= 100; x++)
      {
         for(int y = 2; y <= 100; y++)
         {
            set.add(BigInteger.valueOf(x).pow(y));
         }
      }
      long t1 = System.nanoTime();
      System.out.println(set.size() + " solve time: " + (t1 - t0) / 1000000000.0 + " seconds");
   }
}