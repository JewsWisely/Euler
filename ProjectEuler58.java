import euler.Primes;
import java.util.*;
import java.util.stream.*;

public class ProjectEuler58
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      /*
      out:
      for(int k = 0; k < 45; k += 8)
      {
         for(int i = 1; i < 7; i += 2)
         {
            count++;
            if(p.isPrime(i + k))
            {
               pCount++;
            }
            proportion = pCount / count;
         }
         count++;
         if(proportion <= .1)
         {
            break out;
         }
         System.out.println(proportion);
      }*/
      
      
      //199999023
      //179424673
      
      
      /*
      for(int i = 3; proportion > .1; i += 2)
      {
         if(p.isPrime(i))
            primeCount++;
         proportion = primeCount / ++count;
         if(i % 7777 == 0)
            System.out.println(i + ", " + proportion);
      }*/
      
      
      /*
      Primes p = new Primes(1500000);
      double proportion = 1, count = 1, primeCount = 0;
      int sideLength = 3;
      int[] diags = {3, 5, 7, 9};
      int[] add = {2, 4, 6, 8};
      while(proportion > .1)
      {
         for(int i = 0; i < diags.length; i++)
         {
            if(p.isPrime(diags[i]))
               primeCount++;
            add[i] += 8;
         }
         sideLength += 2;
         count += 4;
         proportion = primeCount / count;
         
         System.out.print(primeCount + " primes, ");
         for(int i = 0; i < diags.length; i++)
         {
            System.out.print(diags[i] + ", ");
            diags[i] += add[i];
         }
         System.out.println("\t" + proportion + "\t" + sideLength);
      }*/
      
      
      
      /*
      Primes p = new Primes(25000000);
      ArrayList<Integer> diags = new ArrayList<Integer>();
      ArrayList<Integer> primes = new ArrayList<Integer>();
      diags.add(1);
      int num = 1, add = 2;
      do
      {
         for(int i = 0; i < 4; i++)
         {
            num += add;
            diags.add(num);
            if(p.isPrime(num))
               primes.add(num);
         }
         add += 2;
         System.out.println(1.0 * primes.size() / diags.size());
      }
      while(1.0 * primes.size() / diags.size() > .1);
      
      System.out.printf("%s, %s, %s\n", primes.size(), diags.size(), Math.sqrt(diags.get(diags.size() - 1)));
      diags.forEach(x -> System.out.print(x + " "));*/
      
      HashSet<Integer> primes = new HashSet<Integer>(Primes.primeStream(30000000).collect(Collectors.toList()));
      int num = 9, add = 2, primeCount = 3;
      do
      {
         add += 2;
         for(int i = 0; i < 3; i++)
         {
            num += add;
            if(primes.contains(num))
               primeCount++;
         }
         num += add;
      }
      while(primeCount / (2.0 * add + 1) > 0.1);
      
      long t1 = System.nanoTime();
      System.out.println(add + 1 + ", solve time: " + (t1 - t0)/1000000.0 + " milliseconds");
   }
}