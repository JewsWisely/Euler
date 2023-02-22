import static euler.Euler.*;
import java.math.BigInteger;
import java.util.stream.*;
import java.util.*;

public class ProjectEuler56
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      for(int e = 0; e < 100; e++)
         printResultWithExponent(e);
      
      long t1 = System.nanoTime();
      System.out.println("solve time: " + (t1 - t0)/1000000.0 + " milliseconds");
   }
   
   public static void printResultWithExponent(int exp)
   {
      System.out.println(Stream.iterate(0, x -> x + 1).limit(100).filter(x -> x % 10 != 0).map(x -> (new BigInteger("" + x)).pow(exp).toString().chars().map(c -> c - '0').reduce(0, (a, b) -> a + b)).max(Integer::compare).get());//.forEach(x -> System.out.println(x))
   }
}