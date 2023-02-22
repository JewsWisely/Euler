package euler;

import java.util.*;
import java.math.BigInteger;
//import java.io.File;

/***********************************************************************************

------------------------------------------------------------------------------------
METHOD NAME:                                RETURN TYPE:                                             
------------------------------------------------------------------------------------
factorial(int)                              double
------------------------------------------------------------------------------------
binary(int)                                 String
------------------------------------------------------------------------------------
isPalindrome(String)                        boolean
------------------------------------------------------------------------------------
getFibonacci(int)                           ArrayList<BigInteger>
------------------------------------------------------------------------------------
getPrimes()                                 ArrayList<Integer>          DO NOT USE
------------------------------------------------------------------------------------
getPrimes(int)                              ArrayList<Integer>          DO NOT USE
------------------------------------------------------------------------------------
getPrimes(int, int)                         ArrayList<Integer>          DO NOT USE
------------------------------------------------------------------------------------
isPandigital(int)                           boolean
------------------------------------------------------------------------------------
isPandigital(String)                        boolean
------------------------------------------------------------------------------------
isPandigital(int, int)                      boolean
------------------------------------------------------------------------------------
isPandigital(String, int)                   boolean
------------------------------------------------------------------------------------
isPandigital(long, int, int)                boolean
------------------------------------------------------------------------------------
isPandigital(String, int, int)              boolean
------------------------------------------------------------------------------------
permutations(String str)                    ArrayList<String>
------------------------------------------------------------------------------------
divisors(long)                              ArrayList<Integer>
------------------------------------------------------------------------------------
primeDivisors(long)                         ArrayList<Integer>          DO NOT USE
------------------------------------------------------------------------------------
primeFactorization(long)                    ArrayList<Integer>          DO NOT USE
------------------------------------------------------------------------------------
integer(String)                             int
------------------------------------------------------------------------------------
integer(char)                               int
------------------------------------------------------------------------------------
reverse(String)                             String


***********************************************************************************/

public class Euler
{
   public static double factorial(int num)
   {
      return num <= 1 ? 1 : num * factorial(num - 1);
   }
   
   public static String binary(int num)
   {
      return Integer.toBinaryString(num);
   }
   
   public static boolean isPalindrome(String s)
   {
      int maxIndex = s.length();
      for(int i = 0; i < maxIndex / 2; i++)
         if(s.charAt(i) != s.charAt(maxIndex - 1 - i))
            return false;
      return true;
   }
   
   public static ArrayList<BigInteger> getFibonacci(int index)
   {
      ArrayList<BigInteger> f = new ArrayList<BigInteger>();
      
      f.add(BigInteger.ONE);
      f.add(BigInteger.ONE);
      
      int size = 2;
      
      while(size < index)
      {
         f.add(f.get(size - 1).add(f.get(size - 2)));
         size++;
      }
      
      return f;
   }
   /*
   public static ArrayList<Integer> getPrimes()
   {
      return getPrimes(0, 10000000);
   }
   
   public static ArrayList<Integer> getPrimes(int index)
   {
      return getPrimes(0, index);
   }
   
   public static ArrayList<Integer> getPrimes(int start, int index)
   {
      if(index > 10000000)
      {
         System.out.println("Value too high");
         return null;
      }
      
      Scanner scanner;
      try
      {
         scanner = new Scanner(new File("C:\\Users\\Joel\\Documents\\Java Programs\\2018 - 2019 School Year\\Euler\\euler\\primes.txt"));
      }
      catch(Exception e)
      {
         System.out.println(e + "\n");
         return null;
      }
      
      ArrayList<Integer> primes = new ArrayList<Integer>();
      
      int num = 0, prime;
      
      if(start > 0)
         for(int i = 0; i < start; i++)
            scanner.nextInt();
      
      while(num++ < index)
         primes.add(scanner.nextInt());
      
      scanner.close();
      
      return primes;
   }*/
   
   public static boolean isPandigital(int num)
   {
      return isPandigital("" + num, 9);
   }
   
   public static boolean isPandigital(String str)
   {
      return isPandigital(str, 9);
   }
   
   public static boolean isPandigital(int num, int max)
   {
      return isPandigital("" + num, max);
   } 
   
   public static boolean isPandigital(String str, int max)
   {
      if(max > 9 || max < 0 || str.length() != max)
         return false;
      for(int i = 1; i <= max; i++)
      {
         if(str.indexOf("" + i) != -1)
            continue;
         return false;
      }
      return true;
   }
   
   public static boolean isPandigital(long num, int min, int max)
   {
      return isPandigital("" + num, min, max);
   }
   
   public static boolean isPandigital(String str, int min, int max)
   {
      if(min < 0 || max > 9)
         return false;
      for(int i = min; i <= max; i++)
      {
         if(str.indexOf("" + i) != -1)
            continue;
         return false;
      }
      return true;
   }
   
   public static ArrayList<String> permutations(String str)
   {
      ArrayList<String> perms = new ArrayList<String>();
      permutations("", str, perms);
      return new ArrayList<String>(perms);
   }   
   
   private static void permutations(String one, String two, ArrayList<String> list)
   {
      if(two.length() == 0)
         list.add(one);
      for(int i = 0; i < two.length(); i++)
         permutations(one + two.charAt(i), two.substring(0, i) + two.substring(i + 1), list);
   }
   
   public static ArrayList<Integer> divisors(long num)
   {
      TreeSet<Integer> divisors = new TreeSet<Integer>();
      
      for(int d = 1; d < num / 2; d++)
         if(num % d == 0)
         {
            divisors.add(d);
            divisors.add((int)num / d);
         }
         
      return new ArrayList<Integer>(divisors);
   }
   /*
   public static ArrayList<Integer> primeDivisors(int num)
   {
      return new ArrayList<Integer>(new TreeSet<Integer>(primeFactorization(num)));
   }
   
   public static ArrayList<Integer> primeFactorization(long num)
   {
      if(num < 2)
         return null;
      
      ArrayList<Integer> factors = new ArrayList<Integer>();
      
      while(num % 2 == 0)
         {
            factors.add(2);
            num /= 2;
         }
      
      for(int f = 3; num != 1; f += 2)
      {
         while(num % f == 0)
         {
            factors.add(f);
            num /= f;
         }
      }
      
      return factors;
   }*/
   
   public static int integer(String str)
   {
      return Integer.parseInt(str);
   }
   
   public static int integer(char c)
   {
      return c - '0';
   }
   
   public static String reverse(String str)
   {
      return (new StringBuilder(str)).reverse().toString();
   }
}