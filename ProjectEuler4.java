public class ProjectEuler4
{
   public static void main(String[] agrs)
   {
      int big = 0;
      for(int i = 999; i >= 100; i--)
      {
         for(int k = 999; k >= 100; k--)
         {
            if(i * k > big && isPalindrome(i * k))
            {
               big = i * k;
               System.out.println("New Biggest Palindrome: " + i * k);
            }
         } 
      }
   }
   public static boolean isPalindrome(int x)
   {
      String str = "" + x;
      String r = "";
      for(int i = 0; i < str.length(); i++)
         r = str.charAt(i) + r;
      return str.equals(r);
   }
}