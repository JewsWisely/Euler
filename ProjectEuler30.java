public class ProjectEuler30
{
   public static void main(String[] args)
   {
      long t0 = System.currentTimeMillis();
      
      int[] pows = new int[10];
      for(int i = 0; i < 10; i++)
         pows[i] = (int)Math.pow(i, 5);
         
      String str;
      int num, sum = 0;
      
      for(int i = 10; i < 1000000; i++)
      {
         str = "" + i;
         num = 0;
         
         for(int k = 0; k < str.length(); k++)
            num += pows[Integer.parseInt(str.substring(k, k + 1))];
            
         if(num == i)
            sum += num;
      }
      
      long t1 = System.currentTimeMillis();
      
      System.out.println(sum + " solve time: " + (t1 - t0) + "ms");
   }
}