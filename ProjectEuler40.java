public class ProjectEuler40
{
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      StringBuilder b = new StringBuilder(1000001);
      
      for(int i = 0; b.length() < 1000000; i++)
         b.append(i);
      
      int prod = 1;
      
      for(int i = 1; i < 1000000; i *= 10)
         prod *= Integer.parseInt(b.substring(i, i + 1));
      
      long t1 = System.nanoTime();
      System.out.println(prod + ", solve time: " + (t1 - t0)/1000000000.0 + " seconds");
   }
}