package euler;
import java.util.stream.*;
import java.util.*;
import java.io.File;

public class Primes
{
   private ArrayList<Integer> list;
   private HashSet<Integer> set;
   private int size;
   
   public Primes()
   {
      size = 30000000;
      setup(0, 30000000);
   }
   
   public Primes(int size)
   {
      this.size = size;
      setup(0, size);
   }
   
   public Primes(int start, int end)
   {
      size = end - start;
      if(size <= 0)
      {
         System.out.println("SIZE OF PRIMES IS NEGATIVE");
         return;
      }
      setup(start, end);
   }
   
   private void setup(int start, int end)
   {
      if(end > 30000000 || start < 0)
      {
         System.out.println("SIZE OF PRIMES IS TOO HIGH");
         return;
      }
   
      Scanner scanner = createScanner();
      
      list = new ArrayList<Integer>(size);
      
      for(int i = 0; i < start; i++)
         scanner.nextInt();
      
      for(int i = start; i < end; i++)
         list.add(scanner.nextInt());
      
      scanner.close();
         
      set = new HashSet<Integer>(list);
      
      System.out.println(list.get(0) + " -> " + list.get(size - 1));
   }
   
   public boolean isPrime(int num)
   {
      return set.contains(num);
   }
   
   public ArrayList<Integer> getList()
   {
      return list;
   }
   
   public HashSet<Integer> getSet()
   {
      return set;
   }
   
   public int size()
   {
      return size;
   }
   
   public int primesBelow(int num)
   {
      if(num > 30000000)
      {
         System.out.println("SIZE OF PRIMES IS TOO HIGH");
         return -1;
      }
      
      if(num < 2)
         return 0;
      
      if(isPrime(num))
         return list.indexOf(num);
      
      while(!isPrime(num))
      {
         num--;
      }
      
      return list.indexOf(num) + 1;
   }
   
   //maybe int num
   public ArrayList<Integer> primeFactorization(long num)
   {
      if(num < 2)
         return null;
      
      ArrayList<Integer> factors = new ArrayList<Integer>();
      
      int prime;
      
      for(int i = 0; num != 1; i++)
      {
         prime = list.get(i);
         while(num % prime == 0)
         {
            factors.add(prime);
            num /= prime;
         }
      }
      
      return factors;
   }
   
   public ArrayList<Integer> primeDivisors(long num)
   {
      return new ArrayList<Integer>(new TreeSet<Integer>(primeFactorization(num)));
   }
   
   public static Stream<Integer> primeStream(int size)
   {
      if(size > 30000000)
      {
         System.out.println("SIZE OF PRIMES IS TOO HIGH");
         return null;
      }
      
      Scanner scanner = createScanner();
      return Stream.iterate(scanner.nextInt(), x -> scanner.nextInt()).limit(size);
   }
   
   private static Scanner createScanner()
   {
      try
      {
         return new Scanner(new File("./primes.txt"));
      }
      catch(Exception e)
      {
         System.out.println(e + "\n");
         return null;
      }
   }
}