import java.util.stream.*;
import java.math.*;

public class ProjectEuler57
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      System.out.println(Stream.iterate(new BigDecimal[]{BigDecimal.valueOf(3), BigDecimal.valueOf(2), BigDecimal.valueOf(1)}, x -> new BigDecimal[]{BigDecimal.ONE.divide(iterations(x[2].intValue() + 1), 5, RoundingMode.HALF_UP).add(BigDecimal.valueOf(1)).multiply((x[0].add(x[1]))).divide(BigDecimal.ONE, 0, RoundingMode.HALF_UP), x[0].add(x[1]), x[2].add(BigDecimal.ONE)}).limit(1000).filter(x -> x[0].toPlainString().length() > x[1].toPlainString().length()).count());
      
      /*
      
      System.out.println
         (
         Stream.iterate
            (
            new BigDecimal[]{BigDecimal.valueOf(3), BigDecimal.valueOf(2), BigDecimal.valueOf(1)}, 
            x -> new BigDecimal[]
               {
               BigDecimal.ONE.divide(iterations(x[2].intValue() + 1), 5, RoundingMode.HALF_UP)
               .add(BigDecimal.valueOf(1))
               .multiply((x[0].add(x[1])))
               .divide(BigDecimal.ONE, 0, RoundingMode.HALF_UP), 
               x[0].add(x[1]), 
               x[2].add(BigDecimal.ONE)
               }
            )
         .limit(1000)
         .filter(x -> x[0].toPlainString().length() > x[1].toPlainString().length())
         .count()
         );
         
      */
      
      long t1 = System.nanoTime();
      System.out.println("solve time: " + (t1 - t0)/1000000.0 + " milliseconds");
   }
   
   public static BigDecimal iterations(int n)
   {
      return n == 1 ? BigDecimal.valueOf(2) : BigDecimal.ONE.divide(iterations(n - 1), 5, RoundingMode.HALF_UP).add(BigDecimal.valueOf(2));
   }
}