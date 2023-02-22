public class ProjectEuler17
{
   public static void main(String[] args)
   {
      int chars = 0;
      for(int i = 1; i <= 1000; i++)
         chars += chars(i);
      System.out.println(chars);
   }
   
   public static int chars(int num)
   {
      int chars = 0;
      if(num == 1000){ //add 8 for the word thousand
         return 8 + chars(num / 1000);
      }
      if(num % 100 == 0){
         return 7 + chars(num / 100);
      }
      if(num >= 100){ //add 7 for the words hundred and and
         return 10 + chars(num / 100) + chars(num % 100);
      }
      if(num >= 90){
         chars += 6;
         num %= 90;
      }
      else if(num >= 80){
         chars += 6;
         num %= 80;
      }
      else if(num >= 70){
         chars += 7;
         num %= 70;
      }
      else if(num >= 60){
         chars += 5;
         num %= 60;
      }
      else if(num >= 50){
         chars += 5;
         num %= 50;
      }
      else if(num >= 40){
         chars += 5;
         num %= 40;
      }
      else if(num >= 30){
         chars += 6;
         num %= 30;
      }
      else if(num >= 20){
         chars += 6;
         num %= 20;
      }
      else if(num == 17){
         return chars + 9;
      }
      else if(num == 15 || num == 16){
         return chars + 7;
      }
      else if(num >= 13){
         return chars + 8;
      }
      if(num == 12){
         return chars + 6;
      }
      if(num == 11){
         return chars + 6;
      }
      if(num == 10){
         return chars + 3;
      }
      if(num == 9){
         return chars + 4;
      }
      if(num == 8){
         return chars + 5;
      }
      if(num == 7){
         return chars + 5;
      }
      if(num == 6){
         return chars + 3;
      }
      if(num == 5){
         return chars + 4;
      }
      if(num == 4){
         return chars + 4;
      }
      if(num == 3){
         return chars + 5;
      }
      if(num == 2){
         return chars + 3;
      }
      if(num == 1){
         return chars + 3;
      }
      return chars;
   }
   
}