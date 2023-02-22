import java.math.BigInteger;

public class ProjectEuler48
{     
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      BigInteger num = new BigInteger("1");
      
      for(int i = 2; i <= 1000; i++)
         if(i % 10 != 0)
            num = num.add((new BigInteger("" + i)).pow(i));
      
      String ans = num.toString();
      ans = ans.substring(ans.length() - 10);
      
      long t1 = System.nanoTime();
      System.out.println(ans + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
   
}