public class ProjectEuler19
{
   public static void main(String[] args)
   {
      int sundays = 0, day = 1;
      int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      for(int year = 1900; year < 2001; year++)
      {
         daysPerMonth[1] = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
         for(int month = 0; month < 12; month++)
         {
            if(day == 0 && year != 1900)
               sundays++;
            day = (day + daysPerMonth[month]) % 7;
         }
      }
      System.out.print(sundays);
   }
}