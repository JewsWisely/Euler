public class ProjectEuler33
{
   public static void main(String[] args)
   {
      long t0 = System.currentTimeMillis();
      String s_den, s_num;
      double den_prod = 1, num_prod = 1;
      for(int den = 12; den < 100; den++)
      {
         for(int num = 11; num < den; num++)
         {
            if(den % 10 == 0 || num % 10 == 0)
               continue;
            s_den = "" + den;
            s_num = "" + num;
            //System.out.printf("%d / %d = %s\n", num, den, 1.0 * num / den);
            
            for(int m = 0; m < 2; m++)
               for(int n = 0; n < 2; n++)
                  if(s_den.charAt(m) == s_num.charAt(n) && 1.0 * Character.getNumericValue(s_num.charAt(1 - n)) / Character.getNumericValue(s_den.charAt(1 - m)) == 1.0 * num / den)
                  {
                     //System.out.printf("%s / %s = %s\n%d / %d = %s\n", s_num.charAt(1 - n), s_den.charAt(1 - m), 1.0 * Character.getNumericValue(s_num.charAt(1 - n)) / Character.getNumericValue(s_den.charAt(1 - m)), num, den, 1.0 * num / den);
                     den_prod *= den;
                     num_prod *= num;
                  }
         }
      }
      long t1 = System.currentTimeMillis();
      System.out.println(num_prod / num_prod + "/" + den_prod / num_prod + ", solve time: " + (t1 - t0) + "ms");
      
   }
}